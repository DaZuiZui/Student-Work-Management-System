<template>
<div>
  <div class="mydiv">
  <el-card shadow="always">
    <el-button type="success" plain style="margin: 5px"  @click="drawer = true" >添加家长</el-button>
    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column
          label="家长姓名"
          width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.parentname }}</span>
        </template>
      </el-table-column>
      <el-table-column
          label="家长账号"
          width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.parentusername }}</span>
        </template>
      </el-table-column>
      <el-table-column
          label="家长密码"
          width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.parentpassword }}</span>
        </template>
      </el-table-column>
      <el-table-column
          label="孩子姓名"
          width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.studentname }}</span>
        </template>
      </el-table-column>
      <el-table-column
          label="孩子账号"
          width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.studentusername }}</span>
        </template>
      </el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <!--              <el-button-->
          <!--                  size="mini"-->
          <!--                  @click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->
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
      title=""
      :visible.sync="drawer"
      :direction="direction"
      :before-close="handleClose">
    <el-divider>添加家长</el-divider>
    <el-row :gutter="20">
      <el-col :span="4"><div class="grid-content bg-purple">&nbsp;</div></el-col>
      <el-col :span="15"><div class="grid-content bg-purple">
        <div>
          <el-input style="margin-bottom: 10px" v-model="addUser.username" placeholder="账号" class="myYSZTIPT"></el-input>
          <el-input  style="margin-bottom: 10px" v-model="addUser.password" placeholder="密码" class="myYSZTIPT"></el-input>
          <el-input style="margin-bottom: 10px" v-model="addUser.name" placeholder="姓名" class = "myYSZTIPT"></el-input>
          <el-input v-model="addUser.sonusername" placeholder="孩子账号" class = "myYSZTIPT"></el-input>
        </div>
        <div style="margin-top: 50px;margin-left: 130px">  <el-button type="success" round style="align-content: center" @click="addparents">添加</el-button></div>
      </div></el-col>
    </el-row>


  </el-drawer>
</div>
</template>

<script>
export default {

  name: "ParentsManagement",
  data() {
    return {
      drawer:false,
      tableData: [{
        parentname: '我是账号',
        parentusername: '王小虎',
        parentpassword :'我是密码',
        studentname :'',
        studentusername:''
      }],
      addUser:{
        username:'',
        password:'',
        name:'',
        sonusername:''
      }
    }
  },
  methods:{
    getList(){
      this.$axios('/getallcxz').then(res =>{
        if (res.data!=null){
          this.tableData = res.data ;
        }
      })
    },
    handleDelete(index, row){
      console.log("这里删除")
      console.log(row.username)
      console.log(row)
      this.$axios('/user/deleteusername?username='+row.parentusername).then(res=>{
        this.getList();
      })
    },
     addparents(){
      let data = {
        username:this.addUser.username,
        password:this.addUser.password,
        name:this.addUser.name,
        role:'guardian',
        sonusername:this.addUser.sonusername
      }
      this.$axios.post('/user/reg',data).then(res=>{
          if (res.data == true || res.data == 'true'){
            this.$message.success("添加成功")
            this.drawer =false;
            this.getList();
          }else {
            this.$message.error("账号已经被使用了")
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
