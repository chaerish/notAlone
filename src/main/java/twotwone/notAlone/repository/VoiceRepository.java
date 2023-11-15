package twotwone.notAlone.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import twotwone.notAlone.domain.Voice;

import java.util.Optional;

@Repository
public interface VoiceRepository extends MongoRepository<Voice,Long> {
    Optional<Voice> findByName(String prompt);
}
