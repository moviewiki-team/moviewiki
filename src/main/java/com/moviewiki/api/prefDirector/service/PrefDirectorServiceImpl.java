package com.moviewiki.api.prefDirector.service;

import com.moviewiki.api.director.domain.Director;
import com.moviewiki.api.directorFilmography.repository.DirectorFilmographyRepository;
import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.prefActor.domain.PrefActor;
import com.moviewiki.api.prefDirector.domain.PrefDirector;
import com.moviewiki.api.prefDirector.repository.PrefDirectorRepository;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import com.moviewiki.api.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Service
public class PrefDirectorServiceImpl implements PrefDirectorService {

    private ReviewRepository reviewRepository;
    private PrefDirectorRepository prefDirectorRepository;
    private DirectorFilmographyRepository directorFilmographyRepository;

    private final EntityManager em;

    public PrefDirectorServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Autowired
    public PrefDirectorServiceImpl(ReviewRepository reviewRepository, PrefDirectorRepository prefDirectorRepository, DirectorFilmographyRepository directorFilmographyRepository, EntityManager em) {

        this.reviewRepository = reviewRepository;
        this.prefDirectorRepository = prefDirectorRepository;
        this.directorFilmographyRepository = directorFilmographyRepository;
        this.em = em;
    }

    @Override
    public void updatePrefDirector(Review review) {

        User user = review.getUser();
        Date directorReviewDate = null; // updatePrefDirector메소드가 호출되는 날짜
        Director director = directorFilmographyRepository.findDirectorByMovie(review.getMovie());
//        List<Review> directorReviewList = reviewRepository.findDirectorReviewListByUserIdAndDirectorId(user.getUserId(), director.getDirectorId());
        List<Review> directorReviewList = reviewRepository.findNationGReviewListByUser(user); //임시코드 삭제예정
        int directorReviewCount = directorReviewList.size(); // 메소드 아무거나 고름 -> 리뷰 카운트 메소드로 변경 예정
        double directorPoint = directorReviewList.hashCode(); // 메소드 아무거나 고름 -> 선호도 계산 메소드로 변경 예정, 평점(-3)의 총합을 directorReviewCount로 나눈 값
        PrefDirector prefDirector = new PrefDirector(user, director, directorPoint, directorReviewCount, directorReviewDate); // PrefDirector 생성
//        prefDirectorRepository.savePrefDirector(prefDirector); //PrefDirector 테이블에 저장

    }

    // 선호 감독 영화 추천
    @Override
    public List<Movie> findAll(String userName){
        String sql = "SELECT * FROM MOVIES\n" +
                "WHERE MOVIE_ID IN(\n" +
                "SELECT MOVIE_ID FROM DIRECTOR_FILMOGRAPHY\n" +
                "WHERE DIRECTOR_ID IN\n" +
                "    (SELECT DIRECTOR_ID from PREF_DIRECTORS \n" +
                "    where DIRECTOR_POINT =\n" +
                "        (select max(DIRECTOR_POINT) from PREF_DIRECTORS where USER_ID = '"+userName+"')))";
        List<Movie> recDirectorList = em.createNativeQuery(sql, Movie.class).getResultList();
        return recDirectorList.subList(0, 12);
    }

    // 민형 - 유저로 선호 액터 리스트
    @Override
    public List<PrefDirector> prefDirectorList(User user) {
        return prefDirectorRepository.findByUser(user);
    }
}
