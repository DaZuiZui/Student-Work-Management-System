<template>
<div>

  <el-row :gutter="20">
    <el-col :span="5"><div class="grid-content bg-purple">&nbsp;</div></el-col>
    <el-col :span="15"><div class="grid-content bg-purple">
      <div class="mydiv">
        <el-card shadow="always">
          <el-button type="success" round style="background: #a2f1b3;border: 0px" @click="ret">返回</el-button>
          <el-row :gutter="20">
            <el-col :span="2"><div class="grid-content bg-purple">&nbsp;</div></el-col>
            <el-col :span="20"><div class="grid-content bg-purple">
              <div style="text-align: center;font-size: 35px ; margin: 15px">上传作业批改信息</div>
              <div style="text-align: center">
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
                      label="学生姓名"
                      width="180">
                    <template slot-scope="scope">
                      <span style="margin-left: 10px">{{ scope.row.name }}</span>
                    </template>
                  </el-table-column>
                  <el-table-column
                      label="提交状态"
                      width="180">
                    <template slot-scope="scope">
                      <span style="margin-left: 10px">{{ scope.row.state }}</span>
                    </template>
                  </el-table-column>

                  <el-table-column label="操作">
                    <template slot-scope="scope">
                      <el-button
                          size="mini"
                          @click="handleEdit(scope.$index, scope.row)">通过</el-button>
                      <el-button
                          size="mini"
                          type="danger"
                          @click="handleDelete(scope.$index, scope.row)">不通过</el-button>
                    </template>
                  </el-table-column>
                </el-table>
              </div>
            </div></el-col>
          </el-row>


        </el-card>
      </div>

    </div></el-col>
  </el-row>



</div>
</template>

<script>
export default {
  name: "updateReview",
  data() {
    return {
      id:'',
      tableData: [{
        username: '123456',
        name: '王小虎',
        state: '未完成'
      }]
    }
  },
  methods:{
    ret(){
      this.$router.push({
        path:'/adminhome'
      })
    },
    handleDelete(index,row){
      this.$axios('/hk/delthedata?username='+row.username+"&homewokeid="+this.id).then(res=>{
        this.getList();
      })
    },
    getList(){
      this.$axios('/hk/getstateaonallhomework?homeworkid='+this.id).then(res =>{
        if (res.data!=null){
          this.tableData = res.data ;
        }
        // for (let i = 0; i <this.tableData.length ; i++) {
        //   this.$axios.get("http://127.0.0.1:8989/hk/gethomeWorkByusername?username="+this.tableData[i].username+"&homewokeid="+this.id)
        //   .then(ress => {
        //       if (ress.data != null){
        //         this.tableData[i].state ='已完成'
        //       }else{
        //         this.tableData[i].state ='未完成'
        //       }
        //   })
        //
        //
        // }

      })
    },
    handleEdit(index,row){
      let data = {
        homewokeid:this.id,
        username:row.username,
        state:'已完成'
      }
      this.$axios.post('/hk/wczy',data).then(res=>{
        console.log(res.data)
        if (res.data == true || res.data == 'true'){
          this.$message.success(data.username+'通过')
          this.getList()
        }
      })
    }
  },
  created() {
    this.id = this.$route.query.id ;
    this.getList();
  }
}
</script>

<style scoped>

</style>
