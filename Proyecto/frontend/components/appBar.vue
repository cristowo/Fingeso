<template>
    <div>
        <v-app-bar elevation="4" height="90">
            
            <a href="/menu">
                <logoUSACH class="logo"></logoUSACH>
            </a>
            <v-spacer></v-spacer>
            Bienvenido/a {{nombre_academico}}
            <v-menu :close-on-content-click="false" :nudge-right="40" offset-y min-width="290px">
                <template v-slot:activator="{ on, attrs }">
                    <v-btn class="ma-2" icon color="primary" v-bind="attrs" v-on="on">
                        <v-icon>mdi-account</v-icon>
                    </v-btn>
                </template>
                <v-list>
                    <v-list-item>
                        <v-list-item-avatar>
                            <v-icon>mdi-account</v-icon>
                        </v-list-item-avatar>
                        <v-list-item-content>
                            <v-list-item-title class="title">{{nombre_academico}}</v-list-item-title>
                            <v-list-item-subtitle>{{correo_usuario}}</v-list-item-subtitle>
                            <v-divider horizontal></v-divider>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                        <v-spacer></v-spacer>
                        <v-btn v-on:click="CerrarSesión()" class="btn-sup primary" elevation="10">
                            <v-icon>
                                mdi-logout
                            </v-icon>
                            <v-divider vertical color="white" style="margin-left:1%; margin-right:1%;"></v-divider>
                            Cerrar Sesión
                        </v-btn>
                    </v-list-item>
                </v-list>
            </v-menu>

        </v-app-bar>
    </div>
</template>

<script>
    export default{
        data(){
            return{
                nombre_academico: "",
                correo_usuario: ""
            }
        },
        mounted(){
            if(typeof window !== 'undefined'){
                if(localStorage.getItem("NombreAcademico")){
                    this.nombre_academico = localStorage.getItem("NombreAcademico");   
                    this.correo_usuario = localStorage.getItem("correo_usuario")
                }
            }
        },

        methods:{
            CerrarSesión(){
            localStorage.clear();
            this.$router.push("/login");
        }
    }

}
</script>
<style>
.logo{
    position: relative !important;
    width: 200px;
}
.texto{
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}
.btn-sup{
    margin-left: 10px;
    color: white !important;
}
</style>