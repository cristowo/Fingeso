<template>
    <div>
        <v-app id="inspire" class="v">
            <v-container>
                <h1>Sistema de Jerarquizacion Academica</h1>
                <v-row no-gutters>
                    <v-col class="login">
                        <v-card class="pa-2" outlined tile>
                            <div>
                                <v-form ref="form" v-model="valid" lazy-validation>
                                    <LogoUSACH class="usach-logo"></LogoUSACH>
                                    <h2>Inicio de Sesión</h2>
                                    <v-divider></v-divider>
                                    <v-text-field v-model="email" :rules="emailRules" label="Correo institucional" required></v-text-field>
                                    <v-text-field v-model="pass" :rules="passRules" label="Contraseña" required ></v-text-field>
                                    <v-btn :disabled="!valid" class="success mr-4" @click="validate" > Ingresar </v-btn>
                                </v-form>
                            </div>
                        </v-card>
                    </v-col>
                </v-row>
            </v-container>
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

<style>
.v{
    background-color: white !important;
}
.usach-logo {
  height: auto;
  width: 40%;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

.login{
    margin-right: 5%;
}

h1 {
    font-size: 35px;
    text-align: center;
    color:black;
    font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

h2 {
    text-align: center;
    font-size: 20px;
    font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

.texto{
    text-align: center;
}
</style>