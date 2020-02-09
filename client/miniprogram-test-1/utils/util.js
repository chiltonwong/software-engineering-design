/*时间处理文件，可require引入*/
function formatTime(date){
  var year = date.getFullyear()
  var month = date.getMonth() + 1 
  var day = date.getDate()
  var hour = date.getHours()
  var minute = date.getMinutes()
  var second = date.getSecond()

  return [year, month, day].map(formatNumber).join('/') + ' ' +[hour, minute, second].map(formatNumber).join(':')
}

function formatNumber(n){
  n = n.toString()
  return n[1] ? n : '0' + n
}

module.exports = {
  formatTime: formatTime
}
