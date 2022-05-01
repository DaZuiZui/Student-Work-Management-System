<template>
<div>
<!--  成绩表-->
  <div>

      <div>
        <el-row :gutter="20">
          <el-col :span="2"><div class="grid-content bg-purple">&nbsp;</div></el-col>
          <el-col :span="16"><div class="grid-content bg-purple">
            <el-card shadow="always"  style="border-radius:25px;width: 100%">
            <div style="margin-left: 40px">
              <el-table
                  :data="tableData"
                  style="width: 100%">
                <el-table-column
                    label="学生账号"
                    width="270">
                  <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.username }}</span>
                  </template>
                </el-table-column>
                <el-table-column
                    label="学生姓名"
                    width="270">
                  <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.name }}</span>
                  </template>
                </el-table-column>
                <el-table-column
                    label="学生成绩"
                    width="180">
                  <template slot-scope="scope">
                    {{scope.row.price}}
                  </template>
                </el-table-column>
              </el-table>
            </div>
            </el-card>
          </div></el-col>

        </el-row>
      </div>
  </div>

</div>
</template>

<script>
export default {
  name: "LeagueTables",
  data() {
    return {
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄',
        tag: '家'
      }]
    }
  },
  methods:{
    getList(){
      this.$axios('/cj/getallchengji').then(res=>{
        this.tableData = res.data;
      })
    }
  },
  created() {
    this.getList()
  }

}
</script>

<style>

</style>
