<template>
    <v-app>
        <div>
            <appBar></appBar>

            <div>
                <v-container>
                    <v-row no-gutters style="margin-bottom: 1%;"
                        v-for="n in 5"
                        :key="n"
                    >
                        <v-col style="margin-bottom:3%; font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; margin-left: 10px;">
                            <v-card shaped style="margin-left:1%;">
                                <v-card-title>Compromiso</v-card-title>
                                <v-card-subtitle>Fecha de inicio - Fecha de termino</v-card-subtitle>
                                <v-card-text>TEXTO</v-card-text>
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
            <Footer></Footer>
        </div>
    </v-app>
</template>
