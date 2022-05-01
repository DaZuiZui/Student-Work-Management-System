<template>
<div>
  <div>
    <h1>作业列表</h1>
    <div v-for="itme in table">
      <el-card shadow="hover">
        <div>{{itme.name}}</div>
        <el-link type="success" @click="details(itme)">作业详情</el-link>
        <el-row :gutter="20">
          <el-col :span="18"><div class="grid-content bg-purple">&nbsp;</div></el-col>
          <el-col :span="6"><div class="grid-content bg-purple">{{itme.state}}</div></el-col>
        </el-row>
      </el-card>
      <div style="margin: 10px">
      </div>
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: "sonHomeWork",
  data(){
    return{
      table:'',
      state:'已完成完成'
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
      this.$axios('/parentsHomewor?username='+this.$store.state.sonusername).then(res=>{
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
