<template>
  <div>
    Selecciona la fecha de fin
    <v-col cols="12" sm="6" md="4">
        <v-dialog ref="dialog"  v-model="modal" :return-value.sync="date" persistent width="290px">
          <template v-slot:activator="{ on, attrs }">
            <v-btn v-model="dateFormatted" value="dateFormatted" class="mx-4 secondary" dark icon v-bind="attrs" v-on="on">
              <v-icon>
                mdi-calendar
              </v-icon>
            </v-btn>
            
          </template>
          <v-date-picker v-model="date" scrollable locale="cl-es">
            <v-spacer></v-spacer>
             <v-btn text color="primary" @click="modal = false">Cancelar</v-btn>
            <v-btn text color="primary" @click="$refs.dialog.save(date)">Ingresar</v-btn>
          </v-date-picker>
        </v-dialog>
      </v-col>
      <p>Fecha seleccionada: {{ dateFormatted }}</p>
  </div>
</template>

<script>
export default{
        data: vm => ({
            date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
            dateFormatted: vm.formatDate((new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)),
            menu: false,
            modal: false,
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
            localStorage.setItem('fechaFin',this.dateFormatted);
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