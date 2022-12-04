<template>
    <div>
        <v-app>
            <v-container>
                <v-row>
                    <v-col class="text-center" justify="center" style="padding-left: 25%; padding-right: 25%;">

                        <v-card class="text-center" justify="center" shaped outlined style="margin-top: 35%" elevation="10">
                            <v-card-title><p style="margin-left:19%">Sistema de Jerarquización Académica</p></v-card-title>
                            <v-card-subtitle><LogoUSACH style="width: 75%;" class="usach-logo"></LogoUSACH></v-card-subtitle>
                            
                            <v-card-text>
                                <v-form ref="form" v-model="valid" lazy-validation>
                                    <v-divider></v-divider>
                                    <v-text-field class="text-center" justify="center" style="margin-left: 25%; margin-right: 25%; margin-top: 5% " v-model="email" :rules="emailRules" label="Correo institucional" required></v-text-field>
                                    <v-text-field style="margin-left: 25%; margin-right: 25%" v-model="pass" :rules="passRules" label="Contraseña" required></v-text-field>

                                    
                                </v-form>
                            </v-card-text>
                            
                            <v-btn style="padding-left:15%; padding-right:15%; margin-left: 2%; margin-top: -1%; margin-bottom:5%" :disabled="!valid" class="primary mr-4" @click="validate"> Ingresar </v-btn>


                        </v-card>

                    </v-col>
                </v-row>
            </v-container>
            <Footer></Footer>
        </v-app>
    </div>
</template>


<script>
import LogoUSACH from '../components/logoUSACH.vue';

  export default {
    data: () => ({
        valid: true,
        pass: "",
        passRules: [
            v => !!v || "Ingresar contraseña",
        ],
        email: "",
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