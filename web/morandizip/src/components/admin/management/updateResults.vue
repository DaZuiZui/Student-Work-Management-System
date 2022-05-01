<template>
<div>
  <div>
    <el-row :gutter="20">
      <el-col :span="2"><div class="grid-content bg-purple">&nbsp;</div></el-col>
      <el-col :span="14"><div class="grid-content bg-purple">
        <el-card shadow="always"  style="border-radius:25px">
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
                label="学生成绩"
                width="120">
              <template slot-scope="scope">
                <el-input v-model="scope.row.price" class="heise"></el-input>
              </template>
            </el-table-column>

            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button
                    size="mini"
                    @click="handleEdit(scope.$index, scope.row)">更新</el-button>
                <el-button
                    size="mini"
                    type="danger"
                    @click="handleDelete(scope.$index, scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </div></el-col>

    </el-row>
  </div>
</div>
</template>

<script>
export default {
  name: "updateResults",
  data(){
    return {
      tableData: [{
        username: '2016-05-02',
        name: '王小虎',
        price: '上海市普陀区金沙江路 1518 弄',
        tag: '家'
      }]
    }
  },
  methods:{
    getList(){
      this.$axios('/cj/getallchengji').then(res=>{
        this.tableData = res.data;
      })
    },
    handleEdit(index,row){
      this.$axios.post("/cj/ucj",row)
      .then(res => {
      })
    }
  },
  created() {
    this.getList();
  }
}
</script>

<style>
.heise > input{
  color: black;
}

</style>
