<template>
  <div class="dashboard-container">
    <div class="dashboard-text">欢迎光临:{{name}} </div>

    <el-row :gutter="20">
      <el-col :span="6">
        <el-card class="box-card">
          <el-col :span="12">
            <svg-icon  icon-class="documentation" ></svg-icon>
          </el-col>
          <el-col :span="12" >
            <div class="card-panel-text">{{ $t('dashboard.document') }}</div>
            <div class="card-panel-num">
              <a href="http://enilu.gitee.io/web-flash" target="_blank">Document</a>
            </div>
          </el-col>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card class="box-card">
          <el-col :span="12">
            <svg-icon  icon-class="user" ></svg-icon>
          </el-col>
          <el-col :span="12" >
            <div class="card-panel-text">{{ $t('dashboard.newUser') }}</div>
            <div class="card-panel-num">102,400</div>
          </el-col>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card class="box-card">
          <el-col :span="12">
            <svg-icon  icon-class="message" ></svg-icon>
          </el-col>
          <el-col :span="12" >
            <div class="card-panel-text">{{ $t('dashboard.message') }}</div>
            <div class="card-panel-num">5</div>
          </el-col>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card class="box-card">
          <el-col :span="12">
            <svg-icon  icon-class="money" ></svg-icon>
          </el-col>
          <el-col :span="12" >
            <div class="card-panel-text">{{ $t('dashboard.income') }}</div>
            <div class="card-panel-num">10000</div>
          </el-col>
        </el-card>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="24">
        <div class="chart section">
        <v-chart :options="lineData"/>
        </div>
      </el-col>
    </el-row>

    <el-row :gutter="20" >
      <el-col :span="12">
      </el-col>

      <el-col :span="12">
        <v-chart :options="barData" class="chart section"/>
      </el-col>
    </el-row>

    <el-row :gutter="20" >
      <el-col :span="12">
        <v-chart :options="pieData" class="chart section"/>
      </el-col>
      <el-col :span="12">
        <el-table :data="tableData" class="section">
          <el-table-column
            prop="date"
            :label="$t('dashboard.date')"
            width="180">
          </el-table-column>
          <el-table-column
            prop="name"
            :label="$t('dashboard.name')"
            width="180">
          </el-table-column>
          <el-table-column
            prop="address"
            :label="$t('dashboard.addr')">
          </el-table-column>
        </el-table>

      </el-col>

    </el-row>
  </div>
</template>


<script src="./dashboard.js"></script>
<style rel="stylesheet/scss" lang="scss" scoped>
  .el-row{
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }

.dashboard {

  &-container {
    padding: 15px;
    background-color: #f0f2f5;
  }
  &-text {
    font-size: 14px;
    line-height: 22px;
    padding-bottom:15px;
  }
}
.echarts{
  width: 100%;
  height: 100%;
}
.box-card{
  height:108px;
}
  .chart{
    height: 350px;
  }
  .section{
    padding:20px;
    background-color: white;
    border: 1px solid #ebeef5;
    box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
  }

  .box-card > div >div > .svg-icon {
    width: 4em;
    height: 4em;
    color:#34bfa3;
  }
  .card-panel-text{
    padding-top:10px;
    font-size:16px;
    color:gray;
  }
  .card-panel-num{
    padding-top:10px;
    font-size:20px;
    font-weight: bold;
  }
</style>
