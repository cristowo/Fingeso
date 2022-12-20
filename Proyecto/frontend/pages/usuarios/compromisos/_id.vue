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
                        <v-col style="margin-bottom:3%; font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; margin-left: 10px;">
                            <v-card shaped style="margin-left:1%;" elevation = "5"> 
                                <v-card-title>Nombre: {{L.nombre}}</v-card-title>
                                <v-card-subtitle>{{L.fecha_inicioSTR}} -> {{L.fecha_terminoSTR}} - {{L.tipo_compromiso}}</v-card-subtitle>
                                <v-card-text>{{L.descripcion}}</v-card-text>
                                <v-divider style="margin-bottom: 0.5%;"></v-divider>
                                <v-card-action>
                                    <v-btn v-bind:href="'/compromiso/evidencia/' + L.id_compromiso" class="botonVer primary" elevation="6" style="margin-bottom: 0.5%; margin-left: 0.5%;">
                                        <v-icon dark>
                                            mdi-eye
                                        </v-icon>
                                        <v-divider vertical color = "white" style = "margin-left: 3%; margin-right: 3%;"></v-divider>
                                        Ver Evidencias
                                    </v-btn>
                                </v-card-action>
                            </v-card>
                        </v-col>
                    </v-row>  
                </v-container>
            </div>
            <Footer></Footer>
        </div>
    </v-app>
</template>

<script>
import axios from 'axios';
import { async } from 'q';
export default {

    name: 'Compromisos',
    data: function(){
        return{
            Lcompromisos: []
        }
    },
    methods:{
        getData: async function(){
            let response = await this.$axios.get("http://localhost:3001/compromiso/viewAll/" + this.$route.params.id) //cambiar puerto cuando lo prueben
            this.Lcompromisos = response.data;
        }
    },
    created:function(){
        this.getData();
    },
    
}
</script>