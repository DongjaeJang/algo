const genre1 = ["classic", "pop", "classic", "classic", "pop"];
const plays1 = [500, 600, 150, 800, 2500];

const solution = (genres, plays) => {
  /*
        조건.
        장르별 가장 많이 재생된 노래 두 곡씩(한 곡밖에 없을 시 한 곡만)
        고유번호 구별.
        1. 가장 많이 재생된 장르가 먼저
        2. 장르 내 가장 많이 재생된 노래가 먼저
        3. 재생 횟수가 같을 경우 고유 번호가 빠른대로
        
        결과 ==> 고유 번호를 순서대로 return
    */
  // 한 곳에 모아준다.
  const summaryGenres = genres.reduce((acc, cur, index) => {
    if (!acc[cur]) {
      acc[cur] = {
        totalPlay: 0,
        playList: [],
      };
    }
    acc[cur].totalPlay += plays[index];
    acc[cur].playList.push([index, plays[index]]);

    return acc;
  }, {});

  // 총 재생 수가 많은 순서대로 장르 정렬
  const summaryGenresList = Object.values(summaryGenres).sort(
    (genre1, genre2) => {
      return genre2.totalPlay - genre1.totalPlay;
    }
  );

  // 각 장르에서 재생 수가 많은 순서대로 정렬
  const answer = summaryGenresList.reduce((acc, genre) => {
    genre.playList.sort((play1, play2) => {
      return play2[1] - play1[1];
    });

    acc.push(genre.playList[0][0]);

    if (genre.playList.length > 1) {
      acc.push(genre.playList[1][0]);
    }

    return acc;
  }, []);

  return answer;
};

console.log(solution(genre1, plays1));
