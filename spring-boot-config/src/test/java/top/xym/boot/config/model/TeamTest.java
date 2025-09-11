package top.xym.boot.config.model;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class TeamTest {
    @Resource
    private Team team;
    @Test
    void textTeam1() {
        log.info("team: {}", team);
        //测试leader是否为xym
        assertEquals("xym", team.getLeader());

        //判断手机号格式是否正确
        //assertEquals(team.getPhone().matches("^[0-9]{11}$"), true);

        //测试团队年龄是否在1-5之间
        //assertEquals(team.getAge() >= 1 && team.getAge() <= 5, true);

        //判断创建时间是否在当前时间之前
        //assertEquals(team.getCreateDate().isBefore(LocalDate.now()), true);
    }

    @Test
    void textTeam2() {
        assertEquals("xym99", team.getLeader());
    }
}