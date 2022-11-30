<template>
  <v-form
    ref="form"
    v-model="valid"
    lazy-validation
  >
    <h1>Inicio de Sesión</h1>
    <v-text-field
      v-model="email"
      :rules="emailRules"
      label="Correo institucional"
      required
    ></v-text-field>

    <v-text-field
      v-model="pass"
      :rules="passRules"
      label="Contraseña"
      required
    ></v-text-field>

      <v-btn
      :disabled="!valid"
      color="success"
      class="mr-4"
      @click="validate"
    >
      Ingresar
    </v-btn>
    

  </v-form>
</template>


<script>
  export default {
    data: () => ({
      valid: true,
      pass: '',
      passRules: [
        v => !!v || 'Ingresar contraseña',
      ],
      email: '',
      emailRules: [
        v => !!v || 'Ingresar correo',
        v => /.+@.+\..+/.test(v) || 'El correo ingresado no es valido',
      ],
      select: null,
      items: [
        'Item 1',
        'Item 2',
        'Item 3',
        'Item 4',
      ],
      checkbox: false,
    }),

    methods: {
      validate () {
        this.$refs.form.validate()
      },
      reset () {
        this.$refs.form.reset()
      },
      resetValidation () {
        this.$refs.form.resetValidation()
      },
    },
  }
</script>