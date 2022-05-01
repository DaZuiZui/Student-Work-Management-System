<template>
  <div>
    <div class="mydiv">
      <el-card shadow="always" style="align-content: center">
        <el-button type="success" plain style="margin: 5px"  @click="drawer = true">添加学生</el-button>
        <el-table
            :data="tableData"
            style="width: 100%">
          <el-table-column
              label="学生账号"
              width="180">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.username }}</span>
            </template>
          </el-table-column>
          <el-table-column
              label="学生密码"
              width="180">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.password }}</span>
            </template>
          </el-table-column>
          <el-table-column
              label="姓名"
              width="180">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.name }}</span>
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
      <el-divider>添加学生</el-divider>
      <el-row :gutter="20">
        <el-col :span="4"><div class="grid-content bg-purple">&nbsp;</div></el-col>
        <el-col :span="15"><div class="grid-content bg-purple">
          <div>
            <el-input style="margin-bottom: 10px" v-model="adduser.username" placeholder="账号" class="myYSZTIPT"></el-input>
            <el-input  style="margin-bottom: 10px" v-model="adduser.password" placeholder="密码" class="myYSZTIPT"></el-input>
            <el-input v-model="adduser.name" placeholder="姓名" class = "myYSZTIPT"></el-input>
          </div>
          <div style="margin-top: 50px;margin-left: 130px">  <el-button type="success" round style="align-content: center" @click="addStudent">添加</el-button></div>

        </div></el-col>
      </el-row>


    </el-drawer>
  </div>
</template>

<script>
export default {
  name: "Student",
  data() {
    return {
      drawer :false,
      tableData: [{
        username: '我是账号',
        name: '王小虎',
        password :'我是密码'
      }],
      adduser:{
        username:'',
        password:'',
        name:''
      }
    }
  },
  methods:{
    getList(){
      this.$axios('/user/role').then(res =>{
        if (res.data!=null){
          this.tableData = res.data ;
        }
      })
    },
    handleDelete(index, row){
      this.$axios('/user/deleteusername?username='+row.username).then(res=>{
        this.getList();
      })
    },
    addStudent(){
      let data ={username:this.adduser.username , password: this.adduser.password, name:this.adduser.name,role:'student'}
      this.$axios.post('/user/reg',data).then(res=>{
        if (res.data == true || res.data=='true'){
          this.$message.success("注册成功");
          this.drawer = false;
          this.getList();
        }
      })
    }
  },
  created() {
    this.getList();
  }
}
</script>

<style>
.myYSZTIPT > input{
  color: black;
}
</style>
