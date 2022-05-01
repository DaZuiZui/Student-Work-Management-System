<template>
<div>
  <h1>作业列表</h1>
  <div v-for="itme in table">
    <el-card shadow="hover">
      <div>{{itme.name}}</div>
      <el-link type="success" @click="details(itme)">作业详情</el-link>
    </el-card>
    <div style="margin: 10px">
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: "homework",
  data(){
    return{
      table:'',
    }
  },
  methods:{

    details(itme){
      this.$router.push({
        path: '/home/jobdetails',
        query:{
          id:itme.id,
          name:itme.name,
          context:itme.context,
          time:itme.time
        }
      })
    },
    getList(){
      this.$axios('/hk/getAll').then(res=>{
        if (res.data !=null){
          this.table = res.data ;
        }
      })
    }
  },
  created() {
    this.getList()
  }
}

</script>

<style scoped>

</style>
