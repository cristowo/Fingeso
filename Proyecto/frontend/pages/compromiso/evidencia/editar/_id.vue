<template>
    <v-app>
        <div>
            <appBar></appBar>
            
            <v-container> 
                <form @submit.prevent="obtener"> 
                <v-card style="font-family:'Lucida', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; text-align: justify;">
                    <v-card-title>Edicion de evidencia</v-card-title>
                    <v-card-subtitle><b>Si ya subió un archivo, al subir otro lo reemplazará</b></v-card-subtitle>
                    <v-divider></v-divider>
                    <v-card-text>
                        <template> 

                        <form enctype="multipart/form-data">
                        <v-file-input v-model ="file" label="Selecciona tu archivo (maximo 600 MB)" show-size counter>
                        </v-file-input>
                        </form>

                        </template>
                        <v-btn @click = "subirNuevoArchivo" dark color="#EA7600" style="margin-bottom: 0.5%; margin-left: 0.5%;">
                            <v-icon dark>
                                mdi-check
                            </v-icon>
                        </v-btn>
                    </v-card-text>
                </v-card>
            </form>
            </v-container>
        
        
        </div>
        <Footer></Footer>
    </v-app>
</template>

<script>
import axios from 'axios';
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
        name: "obtener",
        data: function(){
            return{
                checked: [],
                titulo_comp: "",
                descripcion: "",
                Lcompromisos: [],
                file: null,
            }
        },
        mounted(){
            if(!localStorage.getItem("NombreAcademico")){
               this.$router.push("/login");    
            }
        },
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

            getData: async function(){
                let response = await this.$axios.get("http://localhost:3001/compromiso/view/" + this.$route.params.id) //cambiar puerto cuando lo prueben
                this.Lcompromisos = response.data;
                console.log(this.Lcompromisos);
                if(this.titulo_comp == undefined || this.titulo_comp == ""){
                    this.titulo_comp = this.Lcompromisos.nombre;
                }
                if(this.descripcion == undefined || this.descripcion == ""){
                    this.descripcion = this.Lcompromisos.descripcion;
                }
                if(this.checked[0] == undefined || this.checked[0] == ""){
                    this.checked[0] = this.Lcompromisos.tipo_compromiso;
                }
                let json={
                    "nombre": this.titulo_comp,
                    "descripcion": this.descripcion,
                    "tipo_compromiso": this.checked[0]
                };
                console.log(json);
                await axios.put("http://localhost:3001/compromiso/editar/" + this.$route.params.id, json) //cambiar puerto cuando lo prueben
                this.$router.push('/compromiso/evidencia/' + this.$route.params.id);
            },
            
            parseDate (date) {
                if (!date) return null

                const [day, month, year] = date.split('/')
                return `${day.padStart(2, '0')}-${month.padStart(2, '0')}-${year}`
            },
            async obtener(){
                this.getData();
            },
            // entregar archivo "file" para subida a base de datas
            async subirNuevoArchivo(){
                let formData = new FormData();
                formData.append('file', this.file);
                await axios.post("http://localhost:3001/compromiso/evidencia/subir/" + this.$route.params.id, formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                });
                this.$router.push('/compromiso/evidencia/' + this.$route.params.id);
            }
        }

    }   
</script>

