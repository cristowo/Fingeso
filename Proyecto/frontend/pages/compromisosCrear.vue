<template>
    <v-app>
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
                                    <v-divider></v-divider>
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
                                    <v-divider></v-divider>
                                    <v-expansion-panel-content>
                                        <v-text-field label="Titulo del Compromiso" :rules="rules" hide-details="auto"></v-text-field>
                                    </v-expansion-panel-content>
                                </v-expansion-panel>

                                <v-expansion-panel>
                                    <v-expansion-panel-header>Fechas</v-expansion-panel-header>
                                    <v-divider></v-divider>
                                    <v-expansion-panel-content>

                                        <v-row>
                                            <calendarioInicio></calendarioInicio>
                                            <calendarioFin></calendarioFin>
                                        </v-row>
                                        
                                    </v-expansion-panel-content>
                                </v-expansion-panel>

                                <v-expansion-panel>
                                    <v-expansion-panel-header>Describe tu compromiso</v-expansion-panel-header>
                                    <v-divider></v-divider>
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
    </v-app>
</template>

<script>
    export default{
        data: vm => ({
            rules: [
                value => !!value || 'Rellena este campo.',
                value => (value && value.length >= 3) || 'Minimo 5 caracteres',
            ],
            rules2: [
                value => !!value || 'Rellena este campo.',
                value => (value && value.length >= 50) || 'Minimo 50 caracteres',
            ],
            picker: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),

            date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
            date2: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
            dateFormatted: vm.formatDate((new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)),
            dateFormatted2: vm.formatDate((new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)),
            menu: false,
            menu2: false,
        }),

        computed: {
            computedDateFormatted () {
            return this.formatDate(this.date)
            },
        },

        watch: {
            date (val) {
            this.dateFormatted = this.formatDate(this.date)
            },
        },

        methods: {
            formatDate (date) {
            if (!date) return null

            const [year, month, day] = date.split('-')
            return `${day}/${month}/${year}`
            },

            
            
            parseDate (date) {
            if (!date) return null

            const [day, month, year] = date.split('/')
            return `${day.padStart(2, '0')}-${month.padStart(2, '0')}-${year}`
            },
        },

    }   
</script>

