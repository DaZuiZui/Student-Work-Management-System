<template>
<div>
  <div class="mydiv">
    <el-card shadow="always">
      <el-button type="success" plain style="margin: 5px"  @click="drawer = true,updateAddTitle ='新增作业',textarea='',homeworkTitle=''" >添加作业</el-button>
      <el-table
          :data="tableData"
          style="width: 100%">
        <el-table-column
            label="作业发布时间"
            width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.time }}</span>
          </template>
        </el-table-column>
        <el-table-column
            label="作业标题"
            width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.name }}</span>
          </template>
        </el-table-column>

        <el-table-column label="编辑">
          <template slot-scope="scope">
            <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
  <el-drawer
      :title="updateAddTitle"
      :visible.sync="drawer"
      :direction="direction"
      :before-close="handleClose">
    <div style="height: 40px"></div>
    <el-row :gutter="20">
      <el-col :span="4"><div class="grid-content bg-purple">&nbsp;</div></el-col>
      <el-col :span="15"><div class="grid-content bg-purple">
        <div>
          <el-input class="myYSZTIPT" v-model="homeworkTitle" placeholder="作业标题"></el-input>
          <el-input
              class="myYSZTIPT"
              type="textarea"
              :rows="2"
              placeholder="作业详情"
              v-model="textarea">
          </el-input>
        </div>
        <el-row :gutter="20">
          <el-col :span="8"><div class="grid-content bg-purple">&nbsp;</div></el-col>
          <el-col :span="6"><div class="grid-content bg-purple">
            <div style="height: 15px"></div>
            <el-button v-if="this.updateAddTitle == '新增作业'" type="success" round style="align-content: center" @click="addHomeWork">添加</el-button>
            <el-button v-else type="success" round style="align-content: center" @click="updateHomeWork">修改</el-button>
          </div></el-col>
        </el-row>

          <div>

          </div>


      </div></el-col>
    </el-row>
  </el-drawer>
</div>
</template>

<script>
export default {
  name: "homework",
  data() {
    return {
      drawer:false,
      updateAdd:false,
      updateAddTitle:'',
      textarea:'',
      homeworkTitle :'',
      updateid:'',
      tableData: [{
        time: '2016-05-02',
        name: '王小虎',
        context: '上海市普陀区金沙江路 1518 弄',
        id:''
      }]
    }
  },
  methods:{
    addHomeWork(){
      let data ={
        name: this.homeworkTitle ,
        context:this.textarea
      }
      this.$axios.post('/hk/fabu',data).then(res =>{

        if (res.data == true || res.data =='true'){
            this.$message.success('添加成功');
            this.getList();
            return
        }
        this.$message.error('添加失败')
      })
    },
    getList(){
      this.$axios.get('/hk/getAll').then(res=>{

        if (res.data != null){
          this.tableData = res.data;
          Date.prototype.toLocaleString = function() {
            return this.getFullYear() + "年" + (this.getMonth() + 1) + "月" + this.getDate() + "日 ";
          };
          for (let i = 0; i <this.tableData.length ; i++) {
            this.tableData[i].time = new Date(this.tableData[i].time);
            this.tableData[i].time =  this.tableData[i].time.toLocaleString();
          }
        }
      })
    },
    handleEdit(index , row){
      this.updateAddTitle = "修改作业信息"
      this.drawer =true ;
      this.textarea = row.context ;
      this.homeworkTitle = row.name;
      this.updateid = row.id ;
    },
    updateHomeWork(){
      let data = {
        id:this.updateid,
        name:this.homeworkTitle ,
        context:this.textarea
      }
      this.$axios.post('/hk/updatehome',data).then(res=>{
        console.log(res.data)
        if (res.data == true || res.data== 'true'){

          this.$message.success("修改成功");
          this.drawer = false;
          this.getList()
          return;
        }
        this.$message.success("修改失败");
      })
    },
    handleDelete(index,row){
      // /hk/shanchuzuoye
      this.$axios('/hk/shanchuzuoye?id='+row.id).then(res=>{
        this.getList();
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
