<template>
<div>
    <v-card
      class="mx-auto"
      max-width="344"
    >
      <v-img
        src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
        height="200px"
      ></v-img>
  
      <v-card-title>
        Subir compromiso
      </v-card-title>
  
      <v-card-subtitle>
        Ingresa la informacion necesaria para crear ingresar un compromiso
      </v-card-subtitle>
  
      <v-card-actions>
        <v-btn
          color="orange lighten-2"
          text
        >
          Ver menú
        </v-btn>
  
        <v-spacer></v-spacer>
  
        <v-btn
          icon
          @click="show = !show"
        >
          <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
        </v-btn>
      </v-card-actions>

      <v-expand-transition>
        <div v-show="show">
          <v-divider></v-divider>
  
          <v-card-text>
            <v-form>
                <v-container>
                    <v-text-field
                        label="Describir compromiso"
                    ></v-text-field>

                    <v-btn
                        color="green"
                        elevation="5"
                    >Ingresar compromiso
                    </v-btn>
                </v-container>
            </v-form>

          </v-card-text>
        </div>
      </v-expand-transition>
    </v-card>

</div>

</template>

<script>
export default {
  data: () => ({
    show: false,
    show2: false,
  }),
}
</script>