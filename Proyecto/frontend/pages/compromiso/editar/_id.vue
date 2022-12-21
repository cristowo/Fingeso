<template>
    <v-app>
        <div>
            <appBar></appBar>
            
            <v-container>
                <form @submit.prevent="obtener">
                <v-card style="font-family:'Lucida', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; text-align: justify;">
                    <v-card-title>Edicion del Compromiso {{nombre.nombre}} </v-card-title>
                    <v-card-subtitle><b>Rellena solo los campos que deseas cambiar con la información pertinente</b></v-card-subtitle>
                    <v-divider></v-divider>
                    <v-card-text>
                    
                        <div>
                            <v-expansion-panels multiple>
                                <v-expansion-panel>
                                    <v-expansion-panel-header>Tipo de Compromiso</v-expansion-panel-header>
                                    <v-divider></v-divider>
                                    <v-expansion-panel-content>
                                        <v-container fluid>
                                            <v-checkbox v-model="checked" label="Docencia" value="Docencia"></v-checkbox>
                                            <v-checkbox v-model="checked" label="Investigación" value="Investigacion"></v-checkbox>
                                            <v-checkbox v-model="checked" label="Vinculación con el Medio" value="Vinculacion con el medio"></v-checkbox>
                                        </v-container>
                                    </v-expansion-panel-content>
                                </v-expansion-panel>

                                <v-expansion-panel>
                                    <v-expansion-panel-header>Titulo</v-expansion-panel-header>
                                    <v-divider></v-divider>
                                    <v-expansion-panel-content>
                                        <v-text-field v-model="titulo_comp" label="Titulo del Compromiso" ></v-text-field>
                                    </v-expansion-panel-content>
                                </v-expansion-panel>

                                <v-expansion-panel>
                                    <v-expansion-panel-header>Fechas</v-expansion-panel-header>
                                    <v-divider></v-divider>
                                    <v-expansion-panel-content>

                                        <v-row style="padding-top: 1.6%; padding-left: 5%">
                                            <calendarioInicio style="padding-left: 15%;"></calendarioInicio>
                                            <calendarioFin style="padding-left: 20%;"></calendarioFin>
                                        </v-row>
                                        
                                    </v-expansion-panel-content>
                                </v-expansion-panel>

                                <v-expansion-panel>
                                    <v-expansion-panel-header>Describe tu compromiso</v-expansion-panel-header>
                                    <v-divider></v-divider>
                                    <v-expansion-panel-content>
                                        <v-text-field v-model= "descripcion" label="Descripcion del Compromiso" hide-details="auto"></v-text-field>
                                    </v-expansion-panel-content>
                                </v-expansion-panel>

                            </v-expansion-panels>
                        </div>
                        
                        <v-divider style="margin-top:1%; margin-bottom: 0.5%;"></v-divider>
                        <v-card-actions>
                            <v-btn type= "submit" fab dark color="#EA7600" style="margin-bottom: 0.5%; margin-left: 0.5%;">
                                <v-icon dark>
                                    mdi-check
                                </v-icon>
                            </v-btn>
                        </v-card-actions>
                    
                    </v-card-text>
                </v-card>
            </form>
            </v-container>
        
        
        </div>
        <Footer></Footer>
    </v-app>
</template>

<script>

import axios from 'axios';
    export default{

        name: "obtener",
        data: function(){
            /* Crea valores vacios, pero Lcompromisos es el mas importante por que se cargan  los datos que vienen de los compromisos de interacciones anteriores */
            return{
                checked: "",
                titulo_comp: "",
                descripcion: "",
                Lcompromisos: [],
                nombre: [],
            }
        },
        /* Se restringe el acceso si no se está logueado */
        mounted(){
            if(!localStorage.getItem("NombreAcademico")){
               this.$router.push("/login");    
            }
        },
        methods: {
            /* Se obtienen los datos de la base de datos */
            async getNombre(){
                let response = await this.$axios.get("http://localhost:3001/compromiso/view/" + this.$route.params.id) //cambiar puerto cuando lo prueben
                this.nombre = response.data;
            },

            
            /* Se obtienen los datos de la base de datos, y se almacenan en las variables inicializadas anteriormente, como Lcompromisos */
            getData: async function(){
                let response = await this.$axios.get("http://localhost:3001/compromiso/view/" + this.$route.params.id) //cambiar puerto cuando lo prueben
                this.Lcompromisos = response.data;
                if(this.titulo_comp == undefined || this.titulo_comp == ""){
                    this.titulo_comp = this.Lcompromisos.nombre;
                }
                if(this.descripcion == undefined || this.descripcion == ""){
                    this.descripcion = this.Lcompromisos.descripcion;
                }
                if(this.checked == undefined || this.checked == ""){
                    this.checked = this.Lcompromisos.tipo_compromiso;
                }
                this.fecha_inicioSTR = localStorage.getItem("fechaInicio");
                if(this.fecha_inicioSTR == undefined || this.fecha_inicioSTR == ""){
                    this.fecha_inicioSTR = this.Lcompromisos.fecha_inicioSTR;
                }
                this.fecha_finSTR = localStorage.getItem("fechaFin");
                if(this.fecha_finSTR == undefined || this.fecha_finSTR == ""){
                    this.fecha_finSTR = this.Lcompromisos.fecha_terminoSTR;
                }
                let fechaInicio=this.fecha_inicioSTR;
                let fechaFin=this.fecha_finSTR;
                let diaInicio=parseInt(fechaInicio.substring(0,2));
                let diaFin=parseInt(fechaFin.substring(0,2));
                let mesInicio=parseInt(fechaInicio.substring(3,5));
                let mesFin=parseInt(fechaFin.substring(3,5));
                let anioInicio=parseInt(fechaInicio.substring(6,10));
                let anioFin=parseInt(fechaFin.substring(6,10));
                if(anioInicio>anioFin){
                    alert("La fecha de inicio debe ser menor a la fecha de termino");
                    return;
                }
                if(anioInicio==anioFin){
                    if(mesInicio>mesFin){
                        alert("La fecha de inicio debe ser menor a la fecha de termino");
                        return;
                    }
                    if(mesInicio==mesFin){
                        if(diaInicio>diaFin){
                            alert("La fecha de inicio debe ser menor a la fecha de termino");
                            return;
                        }
                    }
                }
                let json={
                    "nombre": this.titulo_comp,
                    "descripcion": this.descripcion,
                    "tipo_compromiso": this.checked,
                    "fecha_inicioSTR": this.fecha_inicioSTR,
                    "fecha_terminoSTR": this.fecha_finSTR,
                };
                console.log(json);
                /*Se mandan los datos obtenidos a backend para luego almacenarlos en la base de datos */
                await axios.put("http://localhost:3001/compromiso/editar/" + this.$route.params.id, json) 
                localStorage.removeItem('fechaInicio');
                localStorage.removeItem('fechaFin');
                //mensaje de exito
                alert("Compromiso editado con exito");
                this.$router.push('/compromisos');
            },
            
            async obtener(){
                this.getData();
            }
        },

        created:function(){
                this.getNombre();
        },
    }   
</script>

