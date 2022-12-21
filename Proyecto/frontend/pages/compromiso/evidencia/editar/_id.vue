<template>
    <v-app>
        <div>
            <appBar></appBar>
            
            <v-container> 
                <form @submit.prevent="obtener"> 
                <v-card style="font-family:'Lucida', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; text-align: justify;">
                    <v-card-title>Edicion de evidencia</v-card-title>
                    <v-card-subtitle><b>Si ya subió un archivo, al subir otro lo reemplazará</b></v-card-subtitle>
                    <v-divider></v-divider>
                    <v-card-text>
                        <template> 

                        <form enctype="multipart/form-data">
                        <v-file-input v-model ="file" label="Selecciona tu archivo (maximo 600 MB)" show-size counter>
                        </v-file-input>
                        </form>

                        </template>
                        <v-btn @click = "subirArchivo" dark color="#EA7600" style="margin-bottom: 0.5%; margin-left: 0.5%;">
                            <v-icon dark>
                                mdi-check
                            </v-icon>
                        </v-btn>
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
import { async } from 'q';
    export default{
        name: "obtener",
        data: function(){
            return{
                checked: [],
                titulo_comp: "",
                descripcion: "",
                Lcompromisos: [],
                file: null,
            }
        },
        mounted(){
            if(!localStorage.getItem("NombreAcademico")){
               this.$router.push("/login");    
            }
        },
        methods: {
            getData: async function(){
                let response = await this.$axios.get("http://localhost:3001/compromiso/view/" + this.$route.params.id) //cambiar puerto cuando lo prueben
                this.Lcompromisos = response.data;
            },
            
            async obtener(){
                this.getData();
            },
            // entregar archivo "file" para subida a base de datas
            async subirArchivo(){
                // si no se sube nada se manda un mensaje de error
                if(this.file == null){
                    alert("No se ha seleccionado ningun archivo");
                }
                // solo archivos pdf, docx, doc, jpg, png, jpeg
                else if(this.file.type != "application/pdf" && this.file.type != "application/vnd.openxmlformats-officedocument.wordprocessingml.document" && this.file.type != "application/msword" && this.file.type != "image/jpeg" && this.file.type != "image/png" && this.file.type != "image/jpg"){
                    alert("Solo se permiten archivos pdf, docx, doc, jpg, png, jpeg");
                }
                // si el archivo es mayor a 600 MB
                else if(this.file.size > 600000000){
                    alert("El archivo es muy grande");
                }
                else{
                    let formData = new FormData();
                    formData.append('file', this.file);
                    await axios.post("http://localhost:3001/compromiso/evidencia/subir/" + this.$route.params.id, formData, {
                        headers: {
                            'Content-Type': 'multipart/form-data'
                        }
                    });
                    this.$router.push('/compromiso/evidencia/' + this.$route.params.id);
                }
            } 
        }

    }   
</script>

