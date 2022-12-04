<template>
    <div>
        <appBar></appBar>
        <v-container class="cards">
            <v-row no-gutters>
                
            <v-col class="compromiso">
                <v-card class="texto">
                    <v-card-title>Compromisos</v-card-title>
                    <v-card-subtitle>Agrega o edita tus compromisos</v-card-subtitle>
                    <v-card-text>Añade tus compromisos para más adelante aportar evidencia que respalde sus respectivas realizaciones.</v-card-text>
                    <v-divider></v-divider>
                    <v-btn href="/compromisosCrear" class="botonCrear" color="#EA7600" elevation="4">
                        Crear
                    </v-btn>
                    <v-btn href="/compromisos" class="botonVer" color="#002F6C" elevation="4">
                        Ver
                    </v-btn>
                </v-card>
            </v-col>

            <v-col class="evidencia">
                <v-card class="texto">
                    <v-card-title>Evidencias</v-card-title>
                    <v-card-subtitle>Agrega o edita tus evidencias</v-card-subtitle>
                    <v-card-text>Añade todo tipo de evidencias para respaldar las realizaciones de tus compromisos y cumplir tus objetivos.</v-card-text>
                    <v-divider></v-divider>
                    <v-btn href="/evidenciasCrear" class="botonCrear" color="#EA7600" elevation="4">
                        Crear
                    </v-btn>
                    <v-btn href="/evidencias" class="botonVer" color="#002F6C" elevation="4">
                        Ver
                    </v-btn>
                </v-card>
            </v-col>

            <v-col class="evaluacion">
                <v-card class="texto">
                    <v-card-title>Evaluaciones</v-card-title>
                    <v-card-subtitle>Realiza las evaluaciones</v-card-subtitle>
                    <v-card-text>Revisa los compromisos de tus academicos asignados y analiza sus evidencias adjuntadas, para luego puntuarlas como corresponda.</v-card-text>
                    <v-divider></v-divider>
                    <v-btn href="/evaluaciones" color="#EA7600" class="botonBuscar" elevation="4">
                        Buscar
                    </v-btn>
                </v-card>
            </v-col>

            </v-row>
        </v-container>
    </div>
</template>

<style>
.compromiso{
    margin-top: auto;
    margin-right: auto;
    position: left;
}

.evidencia{
    margin-top: auto;
    margin-right: auto;
    margin-left: auto;
}

.evidencia{
    margin-top: auto;
    margin-right: auto;
    margin-left: auto;
}

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