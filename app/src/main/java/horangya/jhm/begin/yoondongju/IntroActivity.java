package horangya.jhm.begin.yoondongju;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

import horangya.jhm.begin.yoondongju.db.DbOpenHelper;
import horangya.jhm.begin.yoondongju.dummy.Poem;

public class IntroActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {


    void resultAction(){
        DbOpenHelper mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();


        Poem item = new Poem();
        item.setPoemTitle("서시");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "죽는 날까지 하늘을 우러러\n" +
                        "한 점 부끄럼이 없기를.\n" +
                        "잎새에 이는 바람에도\n" +
                        "나는 괴로워했다.\n" +
                        "별을 노래하는 마음으로\n" +
                        "모든 죽어가는 것을 사랑해야지.\n" +
                        "그리고 나한테 주어진 길을\n" +
                        "걸어가야겠다.\n" +
                        "오늘밤에도 별이 바람에 스치운다."
        );
        mDbOpenHelper.insertColumn(item);

        item = new Poem();
        item.setPoemTitle("별 헤는 밤");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "계절이 지나가는 하늘에는\n" +
                        "가을로 가득 차 있습니다.\n" +
                        "나는 아무 걱정도 없이\n" +
                        "가을 속의 별들을 다 헤일 듯합니다.\n" +
                        "가슴속에 하나 둘 새겨지는 별을\n" +
                        "이제 다 못 헤는 것은\n" +
                        "쉬이 아침이 오는 까닭이요,\n" +
                        "내일 밤이 남은 까닭이요,\n" +
                        "아직 나의 청춘이 다하지 않은 까닭입니다.\n" +
                        "별 하나에 추억과\n" +
                        "별 하나에 사랑과\n" +
                        "별 하나에 쓸쓸함과\n" +
                        "별 하나에 동경과\n" +
                        "별 하나에 시와\n" +
                        "별 하나에 어머니, 어머니"
        );
        mDbOpenHelper.insertColumn(item);

        item = new Poem();
        item.setPoemTitle("또 다른 고향");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "고향에 돌아온 날 밤에\n" +
                        "내 백골이 따라와 한 방에 누웠다.\n" +
                        "어둔 방은 우주로 통하고\n" +
                        "하늘에선가 소리처럼 바람이 불어온다.\n" +
                        "어둠 속에서 곱게 풍화작용하는\n" +
                        "백골을 들여다보며\n" +
                        "눈물짓는 것이 내가 우는 것이냐\n" +
                        "백골이 우는 것이냐\n" +
                        "아름다운 혼이 우는 것이냐\n" +
                        "지조 높은 개는\n" +
                        "밤을 새워 어둠을 짖는다.\n" +
                        "어둠을 짖는 개는\n" +
                        "나를 쫓는 것일 게다.\n" +
                        "가자 가자\n" +
                        "쫓기우는 사람처럼 가자.\n" +
                        "백골 몰래\n" +
                        "아름다운 또 다른 고향에 가자"
        );

        mDbOpenHelper.insertColumn(item);

        item = new Poem();
        item.setPoemTitle("십자가");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "쫓아오던 햇빛인데\n" +
                        "지금 교회당 꼭대기\n" +
                        "십자가에 걸리었습니다.\n" +
                        "  \n" +
                        "첨탑이 저렇게도 높은데\n" +
                        "어떻게 올라갈 수 있을까요.\n" +
                        "  \n" +
                        "종소리도 들려 오지 않는데\n" +
                        "휘파람이나 불며 서성거리다가\n" +
                        "  \n" +
                        "괴로웠던 사나이\n" +
                        "행복한 예수 그리스도에게\n" +
                        "처럼\n" +
                        "십자가가 허락된다면\n" +
                        " \n" +
                        "모가지를 드리우고\n" +
                        "꽃처럼 붉은 피를\n" +
                        "어두워 가는 하늘 밑에\n" +
                        "조용히 흘리겠습니다."
        );

        mDbOpenHelper.insertColumn(item);
        item = new Poem();
        item.setPoemTitle("쉽게 씌어진 시");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "창밖에 밤비가 속살거려\n" +
                        "육첩방은 남의 나라.\n" +
                        " \n" +
                        "시인이란 슬픈 천명인 줄 알면서도\n" +
                        "한 줄 시를 적어 볼까,\n" +
                        "\n" +
                        "땀내와 사랑내 포근히 품긴\n" +
                        "보내 주신 학비 봉투를 받아\n" +
                        "\n" +
                        "대학 노트를 끼고\n" +
                        "늙은 교수의 강의를 들으러 간다.\n" +
                        "\n" +
                        "생각해 보면 어린 때 동무들\n" +
                        "하나, 둘, 죄다 잃어버리고\n" +
                        "\n" +
                        "나는 무얼 바라\n" +
                        "나는 다만, 홀로 침전하는 것일까?\n" +
                        "\n" +
                        "인생은 살기 어렵다는데\n" +
                        "시가 이렇게 쉽게 쓰여지는 것은\n" +
                        "부끄러운 일이다.\n" +
                        "\n" +
                        "육첩방은 남의 나라\n" +
                        "창밖에 밤비가 속살거리는데,\n" +
                        "\n" +
                        "등불을 밝혀 어둠을 조금 내몰고,\n" +
                        "시대처럼 올 아침을 기다리는 최후의 나.\n" +
                        "\n" +
                        "나는 나에게 작은 손을 내밀어\n" +
                        "눈물과 위안으로 잡는 최초의 악수."
        );
        mDbOpenHelper.insertColumn(item);


        item = new Poem();
        item.setPoemTitle("참회록");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "파란 녹이 낀 구리 거울 속에\n" +
                        "내 얼굴이 남어 있는 것은\n" +
                        "어느 왕조의 유물이기에\n" +
                        "이다지도 욕될가.\n" +
                        "나는 나의 참회의 글을 한 줄에 주리자.\n" +
                        "-- 만 이십 사 년 일 개월을\n" +
                        "무슨 기쁨을 바라 살아 왔든가.\n" +
                        "내일이나 모레나 그 어느 즐거운 날에\n" +
                        "나는 또 한 줄의 참회록을 써야 한다.\n" +
                        "-- 그 때 그 젊은 나이에\n" +
                        "왜 그런 부끄런 고백을 했든가.\n" +
                        "밤이면 밤마다 나의 거울을\n" +
                        "손바닥으로 발바닥으로 닦어 보자.\n" +
                        "그러면 어느 운석 밑으로 홀로 걸어가는\n" +
                        "슬픈 사람의 뒷모양이\n" +
                        "거울 속에 나타나 온다"        );
        mDbOpenHelper.insertColumn(item);


        item = new Poem();
        item.setPoemTitle("간");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "바닷가 햇빛 바른 바위 위에\n" +
                        "습한 간을 펴서 말리우자.\n" +
                        "코카서스 산중에서 도망해 온 토끼처럼\n" +
                        "둘러리를 빙빙 돌며 간을 지키자.\n" +
                        "내가 오래 기르는 여윈 독수리야!\n" +
                        "와서 뜯어먹어라, 시름없이\n" +
                        "\n" +
                        "너는 살찌고\n" +
                        "나는 여위어야지, 그러나\n" +
                        "거북이야\n" +
                        "다시는 용궁의 유혹에 안 떨어진다.\n" +
                        "프로메테우스 불쌍한 프로메테우스\n" +
                        "불 도적한 죄로 목에 맷돌을 달고\n" +
                        "끝없이 침전하는 프로메테우스"        );
        mDbOpenHelper.insertColumn(item);



        item = new Poem();
        item.setPoemTitle("자화상");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "산모퉁이를 돌아 논가 외딴 우물을 \n" +
                        "홀로 찾아가선 가만히 들여다봅니다.\n" +
                        "\n" +
                        "우물 속에는 달이 밝고 구름이 흐르고\n" +
                        "하늘이 펼치고 파아란 바람이 불고 \n" +
                        "가을이 있습니다.\n" +
                        "\n" +
                        "그리고 한 사나이가 있습니다.\n" +
                        "어쩐지 그 사나이가 미워져 돌아갑니다.\n" +
                        "\n" +
                        "돌아가다 생각하니 그 사나이가 가엾어\n" +
                        "집니다.\n" +
                        "도로 가 들여다보니 사나이는 그대로 \n" +
                        "있습니다.\n" +
                        "\n" +
                        "다시 그 사나이가 미워져 돌아갑니다.\n" +
                        "돌아가다 생각하니 그 사나이가 그리워\n" +
                        "집니다.\n" +
                        "\n" +
                        "우물 속에는 달이 밝고 구름이 흐르고 \n" +
                        "하늘이 펼치고 파아란 바람이 불고\n" +
                        "가을이 있고 추억처럼 사나이가 있습니다."        );
        mDbOpenHelper.insertColumn(item);


        item = new Poem();
        item.setPoemTitle("호주머니");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "넣을 것 없어 \n" +
                        "걱정이던 \n" +
                        "호주머니는 \n" +
                        "겨울이면 \n" +
                        "주먹 두 개 갑북갑북"        );
        mDbOpenHelper.insertColumn(item);

        item = new Poem();
        item.setPoemTitle("편지");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "그립다고 써보니 차라리 말을 말자\n" +
                        "그냥 긴 세월이 지났노라고만 쓰자\n" +
                        "긴긴 사연을 줄줄이 이어\n" +
                        "진정 못 잊는다는 말을 말고\n" +
                        "어쩌다 생각이 났었노라고만 쓰자\n" +
                        "\n" +
                        "그립다고 써보니 차라리 말을 말자\n" +
                        "그냥 긴 세월이 지났노라고만 쓰자\n" +
                        "긴긴 잠못 이루는 밤이면\n" +
                        "행여 울었다는 말을 말고\n" +
                        "가다가 그리울 때도 있었노라고만 쓰자."        );
        mDbOpenHelper.insertColumn(item);




        item = new Poem();
        item.setPoemTitle("새로운 길");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "내를 건너서 숲으로\n" +
                        "고개를 넘어서 마을로\n" +
                        "\n" +
                        "어제도 가고 오늘도 갈\n" +
                        "나의 새로운 길\n" +
                        "민들레가 피고 까치가 날고\n" +
                        "아저씨가 지나고 바람이 일고\n" +
                        "\n" +
                        "나의 길은 언제나 새로운 길\n" +
                        "오늘도.....내일도.....\n" +
                        "내를 건너서 숲으로\n" +
                        "고개를 넘어서 마을로\n"        );
        mDbOpenHelper.insertColumn(item);




        item = new Poem();
        item.setPoemTitle("겨울");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "처마 밑에\n" +
                        "시래기 다래미\n" +
                        "바삭바삭\n" +
                        "추워요.\n" +
                        "\n" +
                        "길바닥에\n" +
                        "말똥 동그래미\n" +
                        "달랑달랑\n" +
                        "얼어요."        );
        mDbOpenHelper.insertColumn(item);




        item = new Poem();
        item.setPoemTitle("봄");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "우리 애기는\n" +
                        "아래발치에서 코올코올,\n" +
                        "고양이는 부뜨막에서 가릉가릉,\n" +
                        "\n" +
                        "애기 바람이\n" +
                        "나뭇가지에서 소올소올,\n" +
                        "\n" +
                        "아저씨 해님이\n" +
                        "하늘한가운데서 째앵째앵"        );
        mDbOpenHelper.insertColumn(item);



        item = new Poem();
        item.setPoemTitle("눈");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "지난밤에\n" +
                        "눈이 소오복히 왔네\n" +
                        "\n" +
                        "지붕이랑\n" +
                        "길이랑 밭이랑\n" +
                        "추워한다고\n" +
                        "덮어주는 이불인가봐\n" +
                        "\n" +
                        "그러기에\n" +
                        "추운 겨울에만 내리지"        );
        mDbOpenHelper.insertColumn(item);

        item = new Poem();
        item.setPoemTitle("무서운시간");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "거 나를 부르는 게 누구요\n" +
                        "가랑잎 이파리 푸르러 나오는 그늘인데,\n" +
                        "나 아직 여기 호흡이 남아있소.\n" +
                        "한번도 손들어 보지 못한 나를\n" +
                        "손들어 표할 하늘도 없는 나를\n" +
                        "어디에 내 한 몸 둘 하늘이 있어\n" +
                        "나를 부르는 게요.\n" +
                        "\n" +
                        "일을 마치고 내 죽는 날 아침에는\n" +
                        "서럽지도 않은 가랑잎이 떨어질텐데......\n" +
                        "나를 부르지도 마오."        );
        mDbOpenHelper.insertColumn(item);



        item = new Poem();
        item.setPoemTitle("사랑스런 추억");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "봄이 오던 아침,\n" +
                        "서울 어느 쪼그만 정거장에서 희망과 \n" +
                        "사랑처럼 기차를 기다려,\n" +
                        "나는 플랫폼에 간신한 그림자를 떨어뜨리고,\n" +
                        "담배를 피웠다.\n" +
                        "내 그림자는 담배연기 그림자를 날리고,\n" +
                        "비둘기 한 떼가 부끄러울 것도 없이\n" +
                        "나래 속을 속,속, 햇빛에 비춰 날았다.\n" +
                        "기차는 아무 새로운 소식도 없이\n" +
                        "나를 멀리 실어다 주어,\n" +
                        "봄은 다 가고-\n" +
                        "동경 교외 어느 조용한 하숙방에서\n" +
                        "옛거리에 남은 나를 희망과 사랑처럼 그리워한다.\n" +
                        "\n" +
                        "오늘도 기차는 몇 번이나 무의미하게 지나가고,\n" +
                        "\n" +
                        "오늘도 나는 누구를 기다려\n" +
                        "정거장 가차운 언덕에서 서성거릴 게다.\n" +
                        "\n" +
                        "- 아아 젊음은 오래 거기 남아 있거라"        );
        mDbOpenHelper.insertColumn(item);



        item = new Poem();
        item.setPoemTitle("산협의 추억");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "내 노래는 오히려\n" +
                        "설운 산울림.\n" +
                        "골짜기 길에\n" +
                        "떨어진 그림자는\n" +
                        "너무나 슬프구나\n" +
                        "오후의 명상은\n" +
                        "아 - 졸려."        );
        mDbOpenHelper.insertColumn(item);



        item = new Poem();
        item.setPoemTitle("소년");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "여기저기서 단풍잎 같은 슬픈 가을이 \n" +
                        "뚝뚝 떨어진다.\n" +
                        "단풍잎 떨어져 나온 자리마다 \n" +
                        "봄을 마련해 놓고\n" +
                        "나뭇가지 우에 하늘이 펼쳐져 있다.\n" +
                        "가만히 하늘을 들여다보려면\n" +
                        "눈썹에 파란 물감이 든다.\n" +
                        "두 손으로 따뜻한 볼을 쓸어보면\n" +
                        "손바닥에도 파란 물감이 묻어난다.\n" +
                        "다시 손바닥을 들여다본다.\n" +
                        "손금에는 맑은 강물이 흐르고,\n" +
                        "맑은 강물이 흐르고,\n" +
                        "강물 속에는 사랑처럼 슬픈 얼굴......\n" +
                        "아름다운 순이의 얼굴이 어린다.\n" +
                        "소년은 황홀히 눈을 감어 본다.\n" +
                        "그래도 맑은 강물은 흘러 \n" +
                        "사랑처럼 슬픈 순이의 얼굴......\n" +
                        "아름다운 순이의 얼굴은 어린다.\n"        );
        mDbOpenHelper.insertColumn(item);



        item = new Poem();
        item.setPoemTitle("산협의 추억");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "내 노래는 오히려\n" +
                        "설운 산울림.\n" +
                        "골짜기 길에\n" +
                        "떨어진 그림자는\n" +
                        "너무나 슬프구나\n" +
                        "오후의 명상은\n" +
                        "아 - 졸려."        );
        mDbOpenHelper.insertColumn(item);



        item = new Poem();
        item.setPoemTitle("아우의 인상화");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "붉은 이마에 싸늘한 달이 서리어\n" +
                        "아우의 얼굴은 슬픈 그림이다.\n" +
                        "\n" +
                        "발걸음을 멈추어\n" +
                        "살그머니 앳된 손을 잡으며\n" +
                        "너는 자라 무엇이 되려니」\n" +
                        "사람이 되지」\n" +
                        "아우의 설은 진정코 설은 대답이다.\n" +
                        "\n" +
                        "슬며시 잡았던 손을 놓고\n" +
                        "아우의 얼굴을 다시 들여다본다.\n" +
                        "\n" +
                        "싸늘한 달이 붉은 이마에 젖어\n" +
                        "아우의 얼굴은 슬픈 그림이다."        );
        mDbOpenHelper.insertColumn(item);



        item = new Poem();
        item.setPoemTitle("초 한대");
        item.setPoemWriter("윤동주");
        item.setPoemText(
                "내 방에 품긴 향내를 맡는다.\n" +
                        "\n" +
                        "광명의 제단이 무너지기 전\n" +
                        "나는 깨끗한 제물을 보았다.\n" +
                        "\n" +
                        "염소의 갈비뼈 같은 그의 몸\n" +
                        "그의 생명인 심지\n" +
                        "\n" +
                        "백옥 같은 눈물과 피를 흘려\n" +
                        "불살려 버린다.\n" +
                        "\n" +
                        "그리고 책상머리에 아롱거리며\n" +
                        "선녀처럼 촛불은 춤을 춘다.\n" +
                        "\n" +
                        "매를 본 꿩이 도망하듯이\n" +
                        "암흑이 창구멍으로 도망한\n" +
                        "나의 방에 품긴\n" +
                        "제물의 위대한 향내를 맛보노라."        );
        mDbOpenHelper.insertColumn(item);


        startActivity(new Intent(IntroActivity.this , MainActivity.class));
        finish();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        if (Build.VERSION.SDK_INT >= 23) {

            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                   ) {


                File root = android.os.Environment.getExternalStorageDirectory();//원하는 폴더를 만들기위해 작업
                File dir = new File (root.getAbsolutePath() + "/YUNDONGJU");//이렇게하면 mnt/sdcard/Test 라는 경로가 됩니다.
                if(!dir.exists()) { //폴더가 존재하지 않으면
                    dir.mkdirs();      //생성!
                }
                if(!dir.exists()) { //폴더가 존재하지 않으면
                    dir.mkdirs();      //생성!
                }
                resultAction();

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (Build.VERSION.SDK_INT >= 23) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Log.v(TAG,"Permission: "+permissions[0]+ "was "+grantResults[0]);
                //resume tasks needing this permission
                File root = android.os.Environment.getExternalStorageDirectory();//원하는 폴더를 만들기위해 작업
                File dir = new File (root.getAbsolutePath() + "/YUNDONGJU");//이렇게하면 mnt/sdcard/Test 라는 경로가 됩니다.
                if(!dir.exists()) { //폴더가 존재하지 않으면
                    dir.mkdirs();      //생성!
                }
                if(!dir.exists()) { //폴더가 존재하지 않으면
                    dir.mkdirs();      //생성!
                }

            } else {
                finish();
            }
        }
        resultAction();
    }
}
