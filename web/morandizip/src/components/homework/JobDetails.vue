<template>
<div>
<!--  作业的详情页-->
<!--  v -for-->
  <div class="mydiv">
    <el-card shadow="always">
      <el-divider><div style="font-size: 30px">{{user.name}}</div></el-divider>
      <span style="font-size: 20px">时间:</span>
      {{time}}
      <div style="margin: 30px">
        {{user.context}}
      </div>
    </el-card>
  </div>

</div>
</template>

<script>
export default {
  name: "JobDetails",
  data(){
    return{
      user:{
        id:'1',
        name:'作文题目',
        time:'时间',
        teacher:'',
        context:'正文'
      },
      time :''
    }
  },
  created() {
    this.setData()
    this.getTime()
  },
  methods:{
    setData(){
      this.user.id = this.$route.query.id
      this.user.name = this.$route.query.name
      this.user.context = this.$route.query.context
      // this.tableData[i].time =  this.tableData[i].time.toLocaleString();
      Date.prototype.toLocaleString = function() {
        return this.getFullYear() + "年" + (this.getMonth() + 1) + "月" + this.getDate() + "日 ";
      };
      let t = new Date(this.$route.query.time)
      this.user.time = t.toLocaleString() ;
    },
    getTime(){
      this.$axios('/getHomerkTime?id='+this.user.id).then(res=>{
        this.time = res.data ;
      })
    }
  },

}
</script>

<style scoped>

</style>
