package com.app.story.runner;

import com.app.story.domain.Division;
import com.app.story.domain.Story;
import com.app.story.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class Initializer implements CommandLineRunner {

    private final StoryRepository storyRepository;

    @Override
    public void run(String... args)  {

        log.info("Runner executed ****-----****");
        List<Story> news = List.of(
                new Story(null, "Donald Trump to appear in court and be charged in historic moment Tuesday", "https://www.cnn.com/2023/04/04/politics/donald-trump-arraignment-new-york/index.html", Division.POLITICS, Instant.now()),
                new Story(null, "Mc to meet with Taiwan’s president in California on Wednesday", "https://www.cnn.com/2023/04/03/politics/kevin-mccarthy-taiwan-president-meeting-china/index.html", Division.POLITICS, Instant.now()),
                new Story(null, "The Power’ imagines a world where girls fight back, but the show could use more of a spark", "https://www.cnn.com/2023/03/31/entertainment/the-power-review/index.html", Division.ENTERTAINMENT, Instant.now()),
                new Story(null, "Tesla sales again fall short of production", "https://www.cnn.com/2023/04/02/investing/tesla-sales/index.html", Division.BUSINESS, Instant.now()),
                new Story(null, "Donald Trump to appear in court and be charged in historic moment Tuesday", "https://www.cnn.com/2023/04/04/politics/donald-trump-arraignment-new-york/index.html", Division.POLITICS, Instant.now()),
                new Story(null, "Mc to meet with Taiwan’s president in California on Wednesday", "https://www.cnn.com/2023/04/03/politics/kevin-mccarthy-taiwan-president-meeting-china/index.html", Division.POLITICS, Instant.now()),
                new Story(null, "The Power’ imagines a world where girls fight back, but the show could use more of a spark", "https://www.cnn.com/2023/03/31/entertainment/the-power-review/index.html", Division.ENTERTAINMENT, Instant.now()),
                new Story(null, "Tesla sales again fall short of production", "https://www.cnn.com/2023/04/02/investing/tesla-sales/index.html", Division.BUSINESS, Instant.now())
        );
        try {
            storyRepository.saveAll(news);
            log.info("Data Saved successfully xxx****-----****");
        } catch (Exception exception) {
            log.error("Exception occurred while initializing db data, {}", exception.getMessage());
            throw new RuntimeException("Exception occurred while initializing db data");
        }
    }
}

