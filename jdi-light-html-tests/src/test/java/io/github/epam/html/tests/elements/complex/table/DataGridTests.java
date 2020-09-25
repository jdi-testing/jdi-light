package io.github.epam.html.tests.elements.complex.table;

import io.github.epam.TestsInit;

public class DataGridTests implements TestsInit {
    // public Furniture TABLE = new Furniture().set(x -> {
    //     x.name = "Table"; x.type = "furniture"; x.cost = "3.5"; x.weight = "3.5";
    // });
    // @BeforeMethod
    // public void before() {
    //     shouldBeLoggedIn();
    //     tablePage.open();
    // }
//
    // @Test
    // public void tableParamsTest() {
    //     assertEquals(gridProducts.size(), 4);
    //     assertEquals(gridProducts.count(), 6);
    //     assertEquals(gridProducts.header(), asList("Name", "Type", "Cost", "Weight"));
    //     assertEquals(gridProducts.rowHeader(), asList("1", "2", "3", "4", "5", "6"));
    // }
//
    // @Test
    // public void valueTest() {
    //     String value = gridProducts.getValue();
    //     assertEquals(value,
    //     "Name Type Cost Weight\n" +
    //         "Chair furniture 3.5 2\n" +
    //         "Table furniture 3.5 3.5\n" +
    //         "Sofa furniture 2 2\n" +
    //         "Kitchen kitchen 400\n" +
    //         "Robot robo");
    // }
//
    // @Test
    // public void dataColumnTestIndex() {
    //     assertEquals(gridProducts.row(3).asData(Furniture.class), TABLE);
    // }
//
    // @Test
    // public void dataColumnNameTest() {
    //     assertThat(gridProducts.row("3").asData(Furniture.class), is(TABLE));
    // }
//
    // @Test
    // public void dataFilterTest() {
    //     List<Furniture> rows = map(gridProducts.rows(), row -> row.asData(Furniture.class));
    //     assertThat(rows, hasItem(TABLE));
    // }
//
    // @Test
    // public void allDataFilterTest() {
    //     List<Furniture> rows = map(gridProducts.rows(), row -> row.asData(Furniture.class));
    //     List<Furniture> filteredData = filter(rows, d -> d.name.contains("Tab"));
    //     assertEquals(filteredData.size(), 1);
    //     assertEquals(filteredData.get(0), TABLE);
    // }
//
    // @Test
    // public void commonMatchersTest() {
    //     gridProducts.is().displayed();
    //     gridProducts.has().size(6);
    //     gridProducts.assertThat().size(greaterThan(3));
    //     gridProducts.is().notEmpty().size(lessThanOrEqualTo(5));
    // }
//
    // // Compare Matchers
    // @Test
    // public void rowMatcherTest() {
    //     gridProducts.assertData(Furniture.class).row(d -> d.name.contains("Tab"));
    // }
//
    // @Test
    // public void rowDataMatcherTest() {
    //     gridProducts.assertData(Furniture.class).row(TABLE);
    // }
//
    // @Test
    // public void rowsAllTest() {
    //     gridProducts.assertData(Furniture.class).all().rows(d -> d.name.length() >= 4);
    // }
//
    // @Test
    // public void noRowsTest() {
    //     gridProducts.assertData(Furniture.class).no().rows(d -> isBlank(d.name));
    // }
//
    // @Test
    // public void atLeastTest() {
    //     gridProducts.assertData(Furniture.class).atLeast(3).rows(d -> d.type.contains("furniture"));
    // }
//
    // @Test
    // public void exactMatcherTest() {
    //     gridProducts.assertData(Furniture.class).exact(2).rows(d -> d.cost.contains("3.5"));
    // }
//
    // @Test
    // public void rowDataExactMatcherTest() {
    //     gridProducts.assertData(Furniture.class).exact(1).rows(TABLE);
    // }
//
    // @Test
    // public void tableChainTest() {
    //     gridProducts.assertThat()
    //         .displayed().size(6).size(greaterThan(3)).notEmpty();
    //     gridProducts.assertData(Furniture.class)
    //         .row(d -> d.name.contains("Tab"))
    //         .all().rows(d -> d.name.length() >= 4)
    //         .no().rows(d -> isBlank(d.name))
    //         .atLeast(3).rows(d -> d.type.contains("furniture"))
    //         .and().row(TABLE)
    //         .exact(2).rows(d -> d.cost.contains("3.5"))
    //         .exact(1).rows(TABLE);
    // }
}
