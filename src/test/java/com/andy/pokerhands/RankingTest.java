package com.andy.pokerhands;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingTest {

    @Test
    public void shouldBeInTheCorrectOrder() {
        assertThat(Ranking.HIGH_CARD.ordinal()).isEqualTo(0);
        assertThat(Ranking.PAIR.ordinal()).isEqualTo(1);
        assertThat(Ranking.TWO_PAIRS.ordinal()).isEqualTo(2);
        assertThat(Ranking.THREE_OF_A_KIND.ordinal()).isEqualTo(3);
        assertThat(Ranking.STRAIGHT.ordinal()).isEqualTo(4);
        assertThat(Ranking.FLUSH.ordinal()).isEqualTo(5);
        assertThat(Ranking.FULL_HOUSE.ordinal()).isEqualTo(6);
        assertThat(Ranking.FOUR_OF_A_KIND.ordinal()).isEqualTo(7);
        assertThat(Ranking.STRAIGHT_FLUSH.ordinal()).isEqualTo(8);
    }

}