<template>
    <div>
        <h1></h1>
    </div>
</template>
<script>
    export default {
    name: "IndexRequest",
    created()
    {
        this.$router.push("/login");
    }
    };
</script>