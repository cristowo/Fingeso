<template>
    <div>
        <v-app>
            <v-container>
                <v-row>
                    <v-col class="text-center" justify="center" style="padding-left: 25%; padding-right: 25%;">
                        <v-card class="text-center" justify="center" shaped outlined style="margin-top: 15%" elevation="10">
                            <v-card-title><p style="margin-left:19%">Sistema de Jerarquización Académica</p></v-card-title>
                            <v-card-subtitle><LogoUSACH style="width: 75%;" class="usach-logo"></LogoUSACH></v-card-subtitle>
                            
                            <v-card-text>
                                <v-form @submit.prevent="Iniciar"
                                ref="form" v-model="valid" lazy-validation>
                                    <v-divider></v-divider>
                                    <v-text-field v-model="correo" class="text-center" justify="center" style="margin-left: 25%; margin-right: 25%; margin-top: 5% " :rules="emailRules" label="Correo institucional" required></v-text-field>
                                    <v-text-field v-model="clave" type = "password" style="margin-left: 25%; margin-right: 25%"  :rules="passRules" label="Contraseña" required></v-text-field>

                                     <v-btn type="submit" style="padding-left:15%; padding-right:15%; margin-left: 2%; margin-top: -1%; margin-bottom:5%" :disabled="!valid" class="primary mr-4" @click="validate"> Ingresar </v-btn>
                                </v-form>
                            </v-card-text>
                            
                        </v-card>
                    </v-col>
                </v-row>
            </v-container>
            <Footer></Footer>
        </v-app>
    </div>
</template>
<script>
import axios from 'axios';
import LogoUSACH from '../components/logoUSACH.vue';
  export default {
    /*Se define el nombre de la vista */
    name: 'Iniciar',
        data: function(){
            return{
                /*Se definen las variables que se utilizaran en la vista */
                correo:"",
                clave:""
            }
        },
    /*Validaciones de los campos de texto, para que no esten vacios u otros casos */
    data: () => ({
        valid: true,
        clave: "",
        passRules: [
            v => !!v || "Ingresar contraseña",
        ],
        correo: "",
        emailRules: [
            v => !!v || "Ingresar correo",
            v => /.+@.+\..+/.test(v) || "El correo ingresado no es valido",
        ],
        select: null,
        items: [
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
        ],
        checkbox: false,
    }),
    methods: {
        /*Metod que setea las variables y comprueba si los datos ingresados son válidos */
        async Iniciar(){
                let json={
                    "correo": this.correo,
                    "clave": this.clave
                };
                await axios.post("http://localhost:3001/academicos/login", json)
                .then(data =>{
                /*Se comprueba si el correo y la contraseña ingresados son correctos */
                if(data.status == 200){
                    localStorage.setItem("NombreAcademico", data.data.nombre);
                    localStorage.setItem("correo_usuario", this.correo);
                    localStorage.setItem("IdAcademico", data.data.id_user);
                    if(data.data.nombre === undefined){
                        window.alert("correo o contraseña no coinceden con las credenciales registradas en el sistema")
                    }else{
                        this.$router.push('menu');
                    }
                }
                console.log(data.data.nombre);
                console.log(data);
            });
        },
        validate() {
            this.$refs.form.validate();
        },
        reset() {
            this.$refs.form.reset();
        },
        resetValidation() {
            this.$refs.form.resetValidation();
        },
    },
    components: { LogoUSACH }
}
</script>