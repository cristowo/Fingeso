<template>
    <div>
        <v-app-bar elevation="4" height="90">
            <a href="/menu">
                <logoUSACH class="logo"></logoUSACH>
            </a>
            <v-spacer></v-spacer>
            <div class="texto">
                INFO USUARIO
                <v-btn href="/menu"  class="btn-sup primary" elevation="10">Menu Principal</v-btn>
                <v-btn class="btn-sup secondary" elevation="10">Cerrar Sesión</v-btn>
            </div>
        </v-app-bar>
    </div>
</template>

<style>
.logo{
    position: relative !important;
    width: 200px;
}
.texto{
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}
.btn-sup{
    margin-left: 10px;
    color: white !important;
}
</style>