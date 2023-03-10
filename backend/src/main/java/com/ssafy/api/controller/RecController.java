package com.ssafy.api.controller;

import com.ssafy.api.dto.BaseInfo;
import com.ssafy.api.request.CategoryChoiceReq;
import com.ssafy.api.response.BaseResponseBody;
import com.ssafy.api.response.ActivityRecGetRes;
import com.ssafy.api.response.FoodRecGetRes;
import com.ssafy.api.response.MusicRecGetRes;
import com.ssafy.api.service.RecService;
import com.ssafy.common.auth.HelloStrangerUserDetails;
import com.ssafy.db.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

@Api(value = "추천 API", tags = {"Recommandation"})
@RestController
@RequestMapping("/api/rec")
public class RecController {

    @Autowired
    RecService recService;
    @PostMapping()
    @ApiOperation(value = "결과 카테고리 저장", notes = "<strong>음악,활동,음식 별로 사용자가 YN을 표시한 카테고리, YN</strong>을 가지고 결과를 저장한다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
    })
    public ResponseEntity<? extends BaseResponseBody> registResultCategory(@RequestBody CategoryChoiceReq resultCategory, @ApiIgnore Authentication authentication){
        //TODO 결과저장 컨트롤러
        HelloStrangerUserDetails userDetails = (HelloStrangerUserDetails)authentication.getDetails();
        User user = userDetails.getUser();
        if(resultCategory!=null){
            recService.registResultCategory(resultCategory,user);
            return ResponseEntity.status(200).body(BaseResponseBody.of(200,"결과 전달 성공"));
        }
        return ResponseEntity.status(200).body(BaseResponseBody.of(200,"결과 전달 성공"));
    }

    @GetMapping("/food/{latitude}/{longitude}/{distance}/{key}")
    @ApiOperation(value = "음식 추천 결과 반환", notes = "<strong>사용자 위도, 경도, 반경, 새로고침 횟수 key</strong>를 받고, 추천된 음식과 해당 음식점 정보 리스트를 반환한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
    })
    public ResponseEntity<List<FoodRecGetRes>> getFoodRec(@PathVariable Map<String,String> request, @ApiIgnore Authentication authentication){

        HelloStrangerUserDetails userDetails = (HelloStrangerUserDetails)authentication.getDetails();
        User user = userDetails.getUser();

        int key = Integer.parseInt(request.get("key"));
        double distance = Double.parseDouble(request.get("distance"));
        double latitude = Double.parseDouble(request.get("latitude"));
        double longitude = Double.parseDouble(request.get("longitude"));
        List<FoodRecGetRes> res = recService.getFoodRec(key,distance,latitude,longitude,user);
        return ResponseEntity.status(200).body(res);
    }

    @GetMapping("/music/{key}")
    @ApiOperation(value = "음악 추천 결과 반환", notes = "<strong>새로고침 횟수 key</strong>를 받고, 추천된 음악 리스트를 반환한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
    })
   public ResponseEntity<List<MusicRecGetRes>> getMusicRec(@PathVariable int key, @ApiIgnore Authentication authentication){
        HelloStrangerUserDetails userDetails = (HelloStrangerUserDetails)authentication.getDetails();
        User user = userDetails.getUser();
        List<MusicRecGetRes> res = recService.getMusicRec(key,user);
        return ResponseEntity.status(200).body(res);
    }

    @GetMapping("/activity/{latitude}/{longitude}/{distance}/{key}")
    @ApiOperation(value = "활동 추천 결과 반환", notes = "<strong>사용자 위도, 경도, 반경, 새로고침 횟수 key</strong>를 받고, 추천된 활동과 해당 장소 정보 리스트를 반환한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
    })
    public ResponseEntity<List<ActivityRecGetRes>> getActivityRec(@PathVariable Map<String,String> request, @ApiIgnore Authentication authentication){

        HelloStrangerUserDetails userDetails = (HelloStrangerUserDetails)authentication.getDetails();
        User user = userDetails.getUser();

        int key = Integer.parseInt(request.get("key"));
        double distance = Double.parseDouble(request.get("distance"));
        double latitude = Double.parseDouble(request.get("latitude"));
        double longitude = Double.parseDouble(request.get("longitude"));
        List<ActivityRecGetRes> res = recService.getActivityRec(key,distance,latitude,longitude,user);
        return ResponseEntity.status(200).body(res);
    }

}
