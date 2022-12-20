<template>
    <v-app>
        <div>
            <appBar></appBar>
            
            <v-container class="cards">
                
                <v-row no-gutters>
                
                <v-col class="compromiso" style="padding-left: 2.5%; padding-right: 2.5%; padding-top: 2%;">
                    <v-card class="texto pa-2" elevation="8" width="auto" height="auto" shaped outlined>
                        <v-card-title>Compromisos</v-card-title>
                        <v-card-subtitle>Agrega o edita tus compromisos</v-card-subtitle>
                        <v-card-text>Añade tus compromisos para más adelante aportar evidencia que respalde sus respectivas realizaciones.</v-card-text>
                        <v-divider></v-divider>
                        <v-btn href="/compromisosCrear" class="botonCrear primary" elevation="46">
                            Crear
                        </v-btn>
                        <v-btn v-if="hayCompromisos" href="/compromisos" class="botonVer secondary" elevation="6">
                            Ver
                        </v-btn>
                    </v-card>
                </v-col>
                <v-col v-if="perteneceAcomision" class="evaluacion" style="padding-left: 2.5%; padding-right: 2.5%; padding-top: 20%; padding-bottom:">
                    <v-card class="texto pa-2" elevation="8" width="auto" height="auto" shaped outlined>
                        <v-card-title>Evaluaciones</v-card-title>
                        <v-card-subtitle>Realiza las evaluaciones</v-card-subtitle>
                        <v-card-text>Revisa los compromisos de tus academicos asignados y analiza sus evidencias adjuntadas.</v-card-text>
                        <v-divider></v-divider>
                        <v-btn href="/listaacademicos" class="botonBuscar primary" elevation="6">
                            Buscar
                        </v-btn>
                    </v-card>
                </v-col>

                </v-row>
                
                <!--Carrusel con imagenes para adornar el menu-->
                <v-row>
                    <v-col>
                        <v-card shaped elevation="6" style="margin-top:2%">
                            <v-carousel cycle hide-delimiters height="480"  :show-arrows="false">
                                <v-carousel-item>
                                    <v-img src="/usach_01.jpg" style="max-width: 100%;"></v-img>
                                </v-carousel-item>
                                <v-carousel-item>
                                    <v-img src="/usach_02.jpg" style="max-width: 100%;"></v-img>
                                </v-carousel-item>
                            </v-carousel>
                        </v-card>
                    </v-col>
                </v-row>

            </v-container>
            <Footer></Footer>
        </div>        
    </v-app>
</template>

<script>
import axios from 'axios';
import { async } from 'q';
    export default{
        name:"Menu",
        /*data() define un string vacio que se utilizará en los otros metodos */
        data(){
            return{
                nombre_academico: "",
                perteneceAcomision: false,
                Lcompromisos: [],
                hayCompromisos: false,
            }
        },

        /*mounted() se ejecuta cuando se carga la vista, se utiliza para verificar si el usuario esta logeado */
        mounted(){
            if(!localStorage.getItem("NombreAcademico")){
               this.$router.push("/login");    
        }

        /*Se obtiene el nombre del academico logeado y se guarda en la variable nombre_academico */
        else{
            this.nombre_academico = localStorage.getItem("NombreAcademico");
            if(localStorage.getItem("PC") == "true"){
                this.perteneceAcomision = true;
            }
            let response = axios.get('http://localhost:3001/compromiso/viewAll/'+ localStorage.getItem("IdAcademico"));
            response.then((response) => {
                this.Lcompromisos = response.data;
                if(this.Lcompromisos.length > 0){
                    this.hayCompromisos = true;
                }
            });
        }
    }
}
</script>

<style>

/* Elementos de la vista y estilos definidos para estos, posición, tamanio, etc. */
.texto{
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    text-align: justify;
}

.botonCrear{
    margin-left: 5px;
    margin-top: 5px;
    margin-bottom: 5px;
    color: white !important;
}

.botonEditar{
    margin-left: 5px;
    margin-top: 5px;
    margin-bottom: 5px;
    color: white !important;
}

.botonVer{
    margin-left: 5px;
    margin-top: 5px;
    margin-bottom: 5px;
    color: white !important;
}

.botonBuscar{
    margin-left: 5px;
    margin-top: 5px;
    margin-bottom: 5px;
    color: white !important;
}

</style>