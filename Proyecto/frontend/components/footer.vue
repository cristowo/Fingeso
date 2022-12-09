<template>
    <v-footer absolute padless style="margin-top:5%; position: fixed; bottom: 0;">
        <v-card class="flex" flat tile>
        <v-card-text class="secondary py-2 white--text text-center">
            {{ new Date().getFullYear() }} — <strong>USACH</strong>

            <v-btn class="mx-4" dark icon>
                <v-btn icon href="https://www.facebook.com/universidaddesantiago" target="_blank">
                    <v-icon size="24px">
                        {{ 'mdi-facebook' }}
                    </v-icon>
                </v-btn>
            </v-btn>

            <v-btn class="mx-4" dark icon>
                <v-btn icon href="https://twitter.com/usach" target="_blank">
                    <v-icon size="24px">
                        {{ 'mdi-twitter' }}
                    </v-icon>
                </v-btn>
            </v-btn>

            <v-btn class="mx-4" dark icon>
                <v-btn icon href="https://www.linkedin.com/school/universidad-de-santiago-de-chile/" target="_blank">
                    <v-icon size="24px">
                        {{ 'mdi-linkedin' }}
                    </v-icon>
                </v-btn>
            </v-btn>

            <v-btn class="mx-4" dark icon>
                <v-btn icon href="https://www.instagram.com/usachoficial/" target="_blank">
                    <v-icon size="24px">
                        {{ 'mdi-instagram' }}
                    </v-icon>
                </v-btn>
            </v-btn>
            </v-card-text>
        </v-card>

    </v-footer>
</template>


