<template>
    <v-app>
        <div>
            <appBar></appBar>

            <v-container>
                <v-card style="font-family:'Lucida', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; text-align: justify;">
                    <v-card-title>Registro de Evidencia</v-card-title>
                    <v-card-subtitle><b>Rellena los campos con la informacion pertinente</b></v-card-subtitle>
                    <v-divider></v-divider>
                    <v-card-text>

                        <div>

                            <v-expansion-panels multiple>

                                <v-expansion-panel>
                                    <v-expansion-panel-header>Adjunta links de evidencia</v-expansion-panel-header>
                                    <v-divider></v-divider>
                                    <v-expansion-panel-content>
                                        <v-container fluid grid-list-md>
                                            <v-layout row wrap>
                                                <v-flex>
                                                <v-textarea solo name="input-7-4" label="Ingresa tus links" value=""></v-textarea>
                                                </v-flex>
                                            </v-layout>
                                        </v-container>
                                    </v-expansion-panel-content>
                                </v-expansion-panel>

                                <v-expansion-panel>
                                    <v-expansion-panel-header>Archivos</v-expansion-panel-header>
                                    <v-divider></v-divider>
                                    <v-expansion-panel-content>
                                        <v-file-input show-size counter multiple label= "Selecciona tus archivos"></v-file-input>
                                    </v-expansion-panel-content>
                                </v-expansion-panel>

                            </v-expansion-panels>

                            <v-divider style="margin-top:1%; margin-bottom: 0.5%;"></v-divider>
                            <v-card-action>
                                <v-btn fab dark color="#EA7600" style="margin-bottom: 0.5%; margin-left: 0.5%;">
                                    <v-icon dark>
                                        mdi-plus
                                    </v-icon>
                                </v-btn>
                            </v-card-action>


                        </div>

                    </v-card-text>
                </v-card>
            </v-container>
        </div>
        <Footer></Footer>
    </v-app>
</template>

<script>
    export default{
        data: vm => ({
            rules: [
                value => !!value || 'Rellena este campo.',
                // value => (value && value.length >= 3) || 'Minimo 15 caracteres',
            ],
        })
    }
</script>