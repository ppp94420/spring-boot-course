package enums;

import lombok.Getter;

/**
 * @Author: DELL
 * @Date: 2025/9/12
 * @Version: 1.0
 */
@Getter
public enum ExpressStatus {
    CREATE("已揽收"), TRANSIT("在途中"), SUCCESS("签收");
    private final String info;

    ExpressStatus(String info) {
        this.info = info;
    }
}
