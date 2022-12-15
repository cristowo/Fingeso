<template>
    <v-app>
        <div>
            <appBar></appBar>
            <div>
                <v-container>
                    <v-row no-gutters style="margin-bottom: 1%;"
                        v-for="(L, i) in Lacademicos"
                        :key="i"
                    > 
                        <v-col style="margin-bottom:3%; font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; margin-left: 10px;">
                            <v-card shaped style="margin-left:1%;">
                                <v-card-title>Nombre: {{L.nombre}}</v-card-title>
                                <v-divider style="margin-bottom: 0.5%;"></v-divider>
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

    name: 'ListaAcademicos',
    data: function(){
        return{
            Lacademicos: []
        }
    },
    methods:{
        getData: async function(){
            let response = await this.$axios.get("http://localhost:3001/comisionE/revisionAcademico/" + localStorage.getItem("IdAcademico")) //cambiar puerto cuando lo prueben
            this.Lacademicos = response.data;
        }
    },
    created:function(){
        this.getData();
    },
}
</script>