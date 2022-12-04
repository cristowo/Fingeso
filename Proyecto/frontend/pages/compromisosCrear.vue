<template>
    <div>
        <appBar></appBar>
        
        <v-container>
            <v-card style="font-family:'Lucida', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; text-align: justify;">
                <v-card-title>Creacion de Compromiso</v-card-title>
                <v-card-subtitle><b>Rellena los campos necesarios con la información pertinente</b></v-card-subtitle>
                <v-divider></v-divider>
                <v-card-text>
                
                    <div>
                        <v-expansion-panels multiple>
                            <v-expansion-panel>
                                <v-expansion-panel-header>Tipo de Compromiso</v-expansion-panel-header>
                                <v-expansion-panel-content>
                                    <v-container>
                                        <v-checkbox label="Docencia" hide-details></v-checkbox>
                                        <v-checkbox label="Investigación" hide-details></v-checkbox>
                                        <v-checkbox label="Vinculación con el medio" hide-details></v-checkbox>
                                    </v-container>
                                </v-expansion-panel-content>
                            </v-expansion-panel>

                            <v-expansion-panel>
                                <v-expansion-panel-header>Titulo</v-expansion-panel-header>
                                <v-expansion-panel-content>
                                    <v-text-field label="Titulo del Compromiso" :rules="rules" hide-details="auto"></v-text-field>
                                </v-expansion-panel-content>
                            </v-expansion-panel>

                            <v-expansion-panel>
                                <v-expansion-panel-header>Fechas</v-expansion-panel-header>
                                <v-expansion-panel-content>
                                    <v-container>
                                        <v-row>
                                            <v-text-field label="Fecha de inicio (DIA-MES-AÑO)"  hide-details="auto" style="margin-right:1%;"></v-text-field>
                                            <v-text-field label="Fecha de termino (DIA-MES-AÑO)" hide-details="auto" style="margin-left:1%;"></v-text-field>
                                        </v-row>
                                    </v-container>
                                </v-expansion-panel-content>
                            </v-expansion-panel>

                            <v-expansion-panel>
                                <v-expansion-panel-header>Describe tu compromiso</v-expansion-panel-header>
                                <v-expansion-panel-content>
                                    <v-text-field label="Descripcion del Compromiso" :rules="rules2" hide-details="auto"></v-text-field>
                                </v-expansion-panel-content>
                            </v-expansion-panel>

                        </v-expansion-panels>
                    </div>
                    
                    <v-divider style="margin-top:1%; margin-bottom: 0.5%;"></v-divider>
                    <v-card-action>
                        <v-btn fab dark color="#EA7600" style="margin-bottom: 0.5%; margin-left: 0.5%;">
                            <v-icon dark>
                                mdi-plus
                            </v-icon>
                        </v-btn>
                    </v-card-action>
                
                </v-card-text>
            </v-card>
        </v-container>
        
    </div>
</template>

<script>
    export default{
        data() {
            return {
            rules: [
                value => !!value || 'Rellena este campo.',
                value => (value && value.length >= 3) || 'Minimo 5 caracteres',
            ],
            rules2: [
                value => !!value || 'Rellena este campo.',
                value => (value && value.length >= 50) || 'Minimo 50 caracteres',
            ],
            picker: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
            } 
        },
    }   
</script>

