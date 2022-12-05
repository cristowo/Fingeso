<template>
    <v-app>
        <div>
            <appBar></appBar>
            <v-container class="cards">
                
                <v-row no-gutters>
                
                <v-col class="compromiso" style="padding-left: 2.5%; padding-right: 2.5%; padding-top: 20%;">
                    <v-card class="texto pa-2" elevation="8" width="auto" height="auto" shaped outlined>
                        <v-card-title>Compromisos</v-card-title>
                        <v-card-subtitle>Agrega o edita tus compromisos</v-card-subtitle>
                        <v-card-text>Añade tus compromisos para más adelante aportar evidencia que respalde sus respectivas realizaciones.</v-card-text>
                        <v-divider></v-divider>
                        <v-btn href="/compromisosCrear" class="botonCrear primary" elevation="46">
                            Crear
                        </v-btn>
                        <v-btn href="/compromisos" class="botonVer secondary" elevation="6">
                            Ver
                        </v-btn>
                    </v-card>
                </v-col>

                <v-col class="evidencia" style="padding-left: 2.5%; padding-right: 2.5%; padding-top: 20%;">
                    <v-card class="texto pa-2" elevation="8" shaped outlined>
                        <v-card-title>Evidencias</v-card-title>
                        <v-card-subtitle>Agrega o edita tus evidencias</v-card-subtitle>
                        <v-card-text>Añade todo tipo de evidencias para respaldar las realizaciones de tus compromisos y cumplir tus objetivos.</v-card-text>
                        <v-divider></v-divider>
                        <v-btn href="/evidenciasCrear" class="botonCrear primary" elevation="6">
                            Registrar
                        </v-btn>
                        <v-btn href="/evidencias" class="botonVer secondary" elevation="6">
                            Ver
                        </v-btn>
                    </v-card>
                </v-col>

                <v-col class="evaluacion" style="padding-left: 2.5%; padding-right: 2.5%; padding-top: 20%; padding-bottom:">
                    <v-card class="texto pa-2" elevation="8" width="auto" height="auto" shaped outlined>
                        <v-card-title>Evaluaciones</v-card-title>
                        <v-card-subtitle>Realiza las evaluaciones</v-card-subtitle>
                        <v-card-text>Revisa los compromisos de tus academicos asignados y analiza sus evidencias adjuntadas.</v-card-text>
                        <v-divider></v-divider>
                        <v-btn href="/evaluaciones" class="botonBuscar primary" elevation="6">
                            Buscar
                        </v-btn>
                    </v-card>
                </v-col>

                </v-row>
            </v-container>
            <Footer></Footer>
        </div>        
    </v-app>
</template>

<script>
    export default{
        name:"Menu",
        data(){
            return{
                nombre_academico: ""
            }
        },
        mounted(){
            if(!localStorage.getItem("NombreAcademico")){
               this.$router.push("/login");    
        }
        else{
            this.nombre_academico = localStorage.getItem("NombreAcademico");
        }
    }
}
</script>

<style>


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