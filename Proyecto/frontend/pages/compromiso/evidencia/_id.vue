<template>
    <v-app>
        <div>
            <appBar></appBar>
            <div>
                <v-container>
                    <v-row no-gutters style="margin-bottom: 1%;"
                    v-for="(L, i) in Lcompromisos"
                        :key="i"
                    > 
                        <v-col style="margin-bottom:3% ;font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; margin-left: 10px;">
                            <v-card shaped style="margin-left:1%;">
                                <v-card-title>Evidencia del compromiso: {{L.nombre}} </v-card-title>
                                <v-card-subtitle><b>Fecha de subida: {{L.fecha_inicio}} </b></v-card-subtitle>
                                <v-divider style="margin-bottom: 0.5%;"></v-divider>
                                <v-card-text>
                                Puntaje Academico 1: {{L.puntuacion_academico1}}<br>
                                Puntaje Academico 2: {{L.puntuacion_academico2}}<br>
                                Puntaje Academico 3: {{L.puntuacion_academico3}}<br>
                                Puntaje Promedio: {{L.puntuacion_total}}<br><br>
                                Nombre Archivo actual: {{L.nombre_archivo}}<br>
                                <br>
                                <div v-if= "existeArchivo()">
                                <v-btn @click = "descargar" dark class="primary" style="margin-bottom: 0.5%; margin-left: 0.5%;">
                                    <v-icon dark>
                                        mdi-download
                                    </v-icon>
                                </v-btn>
                                <v-btn @click = "eliminarevidencia" v-if="isOwner(L.id_academico)" dark class="secondary" style="margin-bottom: 0.5%; margin-left: 0.5%;">
                                        <v-icon dark>
                                            mdi-delete
                                        </v-icon>
                                </v-btn>
                                </div>
                                </v-card-text>
                                <v-divider style="margin-bottom: 0.5%;"></v-divider>
                                <v-card-action v-if = "isOwner(L.id_academico)">
                                    <v-btn @click = "editarevidencia" dark class="primary" style="margin-bottom: 0.5%; margin-left: 0.5%;">
                                        <v-icon dark>
                                            mdi-pencil
                                        </v-icon>
                                        Subir/Editar archivo
                                    </v-btn>
                                </v-card-action>
                                <v-card-action v-else>
                                    <v-btn @click.stop="dialog = true" dark class="primary" style="margin-bottom: 0.5%; margin-left: 0.5%;">
                                        <v-icon dark>
                                            mdi-check-all
                                        </v-icon>
                                        Evaluar
                                    </v-btn>
                                        <v-dialog v-model="dialog" max-width="300">
                                            <v-card>
                                            <v-card-title>
                                                Ingrese un puntaje del 0 al 100
                                            </v-card-title>
                                    
                                            <v-card-text>
                                                <v-text-field
                                                    v-model="slider"
                                                    class="mt-0 pt-0"
                                                    hide-details
                                                    single-line
                                                    type="number"
                                                    min=0
                                                    max=100
                                                    style="width: 60px; margin-left:35%;"
                                                    justify="center"
                                                ></v-text-field>
                                            </v-card-text>
                                    
                                            <v-card-actions>
                                                <v-spacer></v-spacer>
                                                <v-btn color="error" text @click="dialog = false">
                                                Cancelar
                                                </v-btn>
                                                <v-btn @click="Open" v-model="valor" color="primary">
                                                Evaluar
                                                </v-btn>
                                            </v-card-actions>
                                            </v-card>
                                    </v-dialog>
                                </v-card-action>
                            </v-card>
                        </v-col>
                    </v-row>
                </v-container>
            </div>
        </div>
        <Footer></Footer>
    </v-app>
</template>
<script>
import axios from 'axios';
import { async } from 'q';
export default {

    name: 'Evidencia',
    data: function(){
        return{
            Lcompromisos: [],
            dialog : false,
            slider: 0,
            puntaje: 0,
            valor: 0,
        }
    },
    methods:{
        getData: async function(){
            let response = await this.$axios.get("http://localhost:3001/compromiso/view/" + this.$route.params.id) //cambiar puerto cuando lo prueben
            this.Lcompromisos.push(response.data);
        },
        isOwner: function(id){
            if(localStorage.getItem("IdAcademico") == id){
                return true;
            }
            else{
                return false;
            }
        },
        async Open(){
            this.dialog = false;
            let response = await this.$axios.put("http://localhost:3001/evaluar/"+ localStorage.getItem("IdAcademico") +"/" + this.$route.params.id + "/" + this.slider);
            // ahora recargamos la pagina automaticamente para que se vea el cambio
            location.reload();
            // notificamos al usuario sobre el cambio con windows alert
            alert("Se ha evaluado el compromiso con exito");
        },
        editarevidencia(){
            this.$router.push('/compromiso/evidencia/editar/' + this.$route.params.id);
        },
        async eliminarevidencia(){
            await axios.post("http://localhost:3001/compromiso/evidencia/eliminar/" + this.$route.params.id);
            location.reload();
        },
        //falta implementar
        descargar(){
            //aceder a link externo
            window.open(this.Lcompromisos[0].link);
        },
        existeArchivo(){
            if(this.Lcompromisos[0].nombre_archivo == null){
                return false;
            }
            else{
                return true;
            }
        },

    },
    created:function(){
        this.getData();
    },
    
}
</script>