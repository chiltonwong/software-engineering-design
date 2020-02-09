<template>
  <div class="app-container">
    <div class="block">
      <el-row  :gutter="20">
        <el-col :span="6">
          <el-input v-model="listQuery.userID" placeholder="联系人ID"></el-input>
        </el-col>
        <el-col :span="6">
          <el-input v-model="listQuery.mobile"  placeholder="手机号"></el-input>
        </el-col>
        <el-col :span="8">
          <el-date-picker
            v-model="rangeDate"
            type="datetimerange"
            :picker-options="pickerOptions"
            range-separator="至"
            start-placeholder="下单开始日期"
            end-placeholder="下单截至日期"
            value-format="yyyyMMddHHmmss"
            align="right">
          </el-date-picker>
        </el-col>
        <el-col :span="4">
          <el-button type="success" icon="el-icon-search" @click.native="search">{{ $t('button.search') }}</el-button>
          <el-button type="primary" icon="el-icon-refresh" @click.native="reset">{{ $t('button.reset') }}</el-button>
        </el-col>
      </el-row>
      <br>

    </div>


    <el-table :data="list" v-loading="listLoading" element-loading-text="Loading" border fit highlight-current-row
    @current-change="handleCurrentChange">

      <el-table-column type="expand">
        <template slot-scope="scope">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="点菜单:">
              <template>
                <el-table
                  :data="scope.row.content.list"
                  border=false
                  show-summary
                  style="width: 100%">
                  <el-table-column
                    prop="name"
                    label="菜品名称"
                    width="120">
                  </el-table-column>
                  <el-table-column
                    prop="amount"
                    label="数目"
                    width="120">
                  </el-table-column>
                  <el-table-column
                    prop="price"
                    label="价格"
                    width="120">
                  </el-table-column>
                </el-table>
              </template>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column label="订单ID">
        <template slot-scope="scope">
          {{scope.row.id}}
        </template>
      </el-table-column>
      <el-table-column label="联系人ID">
        <template slot-scope="scope">
          {{scope.row.userID}}
        </template>
      </el-table-column>
      <el-table-column label="联系手机">
        <template slot-scope="scope">
          {{scope.row.mobile}}
        </template>
      </el-table-column>
      <el-table-column label="订单状态">
        <template slot-scope="scope">
          {{scope.row.status}}
        </template>
      </el-table-column>
      <el-table-column label="下单时间">
        <template slot-scope="scope">
          {{scope.row.createTime}}
        </template>
      </el-table-column>
      <el-table-column label="备注">
        <template slot-scope="scope">
          {{scope.row.remark}}
        </template>
      </el-table-column>

    </el-table>

    <el-pagination
      background
      layout="total, sizes, prev, pager, next, jumper"
      :page-sizes="[10, 20, 50, 100,500]"
      :page-size="listQuery.limit"
      :total="total"
      @size-change="changeSize"
      @current-change="fetchPage"
      @prev-click="fetchPrev"
      @next-click="fetchNext">
    </el-pagination>

  </div>
</template>

<script src="./order.js"></script>


<style rel="stylesheet/scss" lang="scss" scoped>
  @import "src/styles/common.scss";

  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>

