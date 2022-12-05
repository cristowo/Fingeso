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
                                <v-card-title>Evidencia del compromiso: {{L.nombre}}</v-card-title>
                                <v-card-subtitle><b>Fecha de subida: {{L.fecha_inicio}} </b></v-card-subtitle>
                                <v-card-text>Contenido: {{L.link}}</v-card-text>
                                <v-divider style="margin-bottom: 0.5%;"></v-divider>
                                <v-card-action>
                                    <v-btn fab dark class="primary" style="margin-bottom: 0.5%; margin-left: 0.5%;">
                                        <v-icon dark>
                                            mdi-pencil
                                        </v-icon>
                                    </v-btn>
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

    name: 'Compromisos',
    data: function(){
        return{
            Lcompromisos: []
        }
    },
    methods:{
        getData: async function(){
            let response = await this.$axios.get("http://localhost:3001/compromiso/viewAll/" + localStorage.getItem("IdAcademico")) //cambiar puerto cuando lo prueben
            //console.log(response.data);
            this.Lcompromisos = response.data;
            //console.log(this.Lcompromisos)
        }
    },
    created:function(){
        this.getData();
    },
    
}
</script>