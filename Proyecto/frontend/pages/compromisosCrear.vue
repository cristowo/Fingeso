<template>
    <v-app>
        <div>
            <appBar></appBar>

            <v-container>
                <form @submit.prevent="obtener">
                <v-card style="font-family:'Lucida', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; text-align: justify;">
                    <v-card-title>Creacion de Compromiso</v-card-title>
                    <v-card-subtitle><b>Rellena los campos necesarios con la información pertinente</b></v-card-subtitle>
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
                                        <v-text-field v-model="titulo_comp" label="Titulo del Compromiso" hide-details="auto"></v-text-field>
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
                                    mdi-plus
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
        data(){
            return{
               /* Variables a utilizar inicializadas en vacio*/
                checked: "",
                titulo_comp: "",
                descripcion: ""
            }
        },
        mounted(){
            /*Validacion de que el usuario este logeado*/
            if(!localStorage.getItem("NombreAcademico")){
               this.$router.push("/login");    
            }
        },
        methods: {
            async obtener(){
                /*Se crea un objeto json con los datos del formulario y se manda al backend para crear el compromiso en la BD*/
                //caso donde faltan datos
                if(this.titulo_comp=="" || this.descripcion=="" || this.checked==""){
                    alert("Faltan datos por llenar");
                    return;
                }
                // para fechas vacias
                if(localStorage.getItem('fechaInicio')==null || localStorage.getItem('fechaFin')==null){
                    alert("Faltan fecahas por llenar");
                    return;
                }
                //fechasInicio debe ser menor a fechaFin
                //convertir fechas a 2 primeros numeros a int
                let fechaInicio=localStorage.getItem('fechaInicio');
                let fechaFin=localStorage.getItem('fechaFin');
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
                    "id_academico": localStorage.getItem("IdAcademico"),
                    "nombre": this.titulo_comp,
                    "tipo_compromiso": this.checked,
                    "descripcion": this.descripcion,
                    "fecha_inicioSTR": localStorage.getItem('fechaInicio'),
                    "fecha_terminoSTR": localStorage.getItem('fechaFin')
                };
                await axios.post("http://localhost:3001/compromiso/crear", json) 
                .then(response =>{
                    console.log(response);
                    
                })
                /*Se eliminan las variables de localStorage para que no se repitan*/
                localStorage.removeItem('fechaInicio');
                localStorage.removeItem('fechaFin');
                this.$router.push('compromisos');
            }
        }
    }   
</script>