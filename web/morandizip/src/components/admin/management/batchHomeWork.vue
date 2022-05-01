<template>
<div>
  <h1>作业列表</h1>
  <div v-for="itme in table">
    <el-card shadow="hover">
      <div>{{itme.name}}</div>
      <el-link type="success" @click="details(itme.id)">上传作业批阅信息</el-link>
    </el-card>
    <div style="margin: 10px">

    </div>
  </div>

</div>
</template>

<script>
export default {
  name: "batchHomeWork",
  data(){
    return{
      id:'',
      table:[
        {
          id:'1',
          name:'标题',
          context:'我是正文',
        }
      ]
    }
  },
  methods:{
    details(id){
      this.$router.push({
        path: '/updatereview',
        query:{
          id:id
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
    this.getList();
  }
}
</script>

<style scoped>

</style>
