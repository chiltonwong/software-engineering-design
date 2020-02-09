import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/order/list',
    method: 'get',
    params
  })
}
export function confirm(params) {
  return request({
    url: '/order',
    method: 'post',
    data: params
  })
}
