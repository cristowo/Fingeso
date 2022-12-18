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
        data: vm => ({
            rules: [
                value => !!value || 'Rellena este campo.',
                value => (value && value.length >= 3) || 'Minimo 5 caracteres',
            ],
            rules2: [
                value => !!value || 'Rellena este campo.',
                value => (value && value.length >= 50) || 'Minimo 50 caracteres',
            ],
            picker: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
            date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
            date2: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
            dateFormatted: vm.formatDate((new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)),
            dateFormatted2: vm.formatDate((new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)),
            menu: false,
            menu2: false,
        }),
        name: "obtener",
        data(){
            return{
                checked: "",
                titulo_comp: "",
                descripcion: ""
            }
        },
        mounted(){
            if(!localStorage.getItem("NombreAcademico")){
               this.$router.push("/login");    
            }
        },
        computed: {
            computedDateFormatted () {
            return this.formatDate(this.date)
            },
            
        },
        watch: {
            date (val) {
            this.dateFormatted = this.formatDate(this.date)
            },
        },
        methods: {
            formatDate (date) {
            if (!date) return null
            const [year, month, day] = date.split('-')
            return `${day}/${month}/${year}`
            },
            
            
            parseDate (date) {
            if (!date) return null
            const [day, month, year] = date.split('/')
            return `${day.padStart(2, '0')}-${month.padStart(2, '0')}-${year}`
            },
            async obtener(){
                let json={
                    "id_academico": localStorage.getItem("IdAcademico"),
                    "nombre": this.titulo_comp,
                    "tipo_compromiso": this.checked,
                    "descripcion": this.descripcion,
                    "fecha_inicioSTR": localStorage.getItem('fechaInicio'),
                    "fecha_terminoSTR": localStorage.getItem('fechaFin')
                };
                await axios.post("http://localhost:3001/compromiso/crear", json) //cambiar puerto cuando lo prueben
                .then(response =>{
                    console.log(response);
                    //console.log(localStorage.getItem('fechaInicio'));
                    
                })
                localStorage.removeItem('fechaInicio');
                localStorage.removeItem('fechaFin');
                this.$router.push('compromisos');
            }
        }
    }   
</script>