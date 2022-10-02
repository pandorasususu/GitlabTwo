import { getApiInstance } from 'api';

const api = getApiInstance();

export function getUserHistory() {
    return api.get('/review')
    .then((res)=>{
        console.log('다시보기 리스트 불러오기', res.data.contents)
        return res.data.contents
    })
    .catch((err)=>{
        console.error(err)
    })
}

export function getUserDetail(reviewId) {
    return api.get(`/detail/${reviewId}`)
    .then((res)=>{
        console.log('다시보기 세부 일정 불러오기', res.data)
        return res.data
    })
    .catch((err)=>{
        console.error(err)
    });
}

export function getUserActivity(activityId){
    api.get(`/detail/activity/${activityId}`)
    .then((res)=> {
        console.log('활동 상세 정보',res.data)
    })
    .catch((err)=>{
        console.error(err)
    })
}
export function getUserFood(foodId){
    api.get(`/detail/food/${foodId}`)
    .then((res)=> {
        console.log('음식 상세 정보',res.data)
    })
    .catch((err)=>{
        console.error(err)
    })
}

export function rateRecommendation({reviewId, rating}){
    api.post(`detail/detail/${reviewId}/rating`,
        {
        rating,
        //body내용, 아마 바뀔 듯
        // "activity": {
        //     "category": "string",
        //     "choiceYN": "string"
        // },
        // "food": {
        //     "category": "string",
        //     "choiceYN": "string"
        // },
        // "music": {
        //     "choiceYN": "string",
        //     "id": 0
        // },
        }
    )
    .then((res)=> {
        console.log(res)
    })
    .catch((err)=>{
        console.error(err)
    })
}