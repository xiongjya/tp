package nurseybook.testutil;

import static nurseybook.logic.commands.TaskCommandTestUtil.VALID_DATE_JAN;
import static nurseybook.logic.commands.TaskCommandTestUtil.VALID_DATE_NOV;
import static nurseybook.logic.commands.TaskCommandTestUtil.VALID_DESC_COVID;
import static nurseybook.logic.commands.TaskCommandTestUtil.VALID_DESC_MEDICINE;
import static nurseybook.logic.commands.TaskCommandTestUtil.VALID_DESC_PAPERWORK;
import static nurseybook.logic.commands.TaskCommandTestUtil.VALID_DESC_VACCINE;
import static nurseybook.logic.commands.TaskCommandTestUtil.VALID_NAME_ALEX;
import static nurseybook.logic.commands.TaskCommandTestUtil.VALID_NAME_KEITH;
import static nurseybook.logic.commands.TaskCommandTestUtil.VALID_TIME_SEVENPM;
import static nurseybook.logic.commands.TaskCommandTestUtil.VALID_TIME_TENAM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nurseybook.model.NurseyBook;
import nurseybook.model.task.Recurrence;
import nurseybook.model.task.Task;

public class TypicalTasks {

    public static final Task KEITH_INSULIN = new TaskBuilder().withDesc(VALID_DESC_MEDICINE)
            .withDateTime(VALID_DATE_NOV, VALID_TIME_SEVENPM).withNames(VALID_NAME_KEITH)
            .withStatus("false", "true")
            .withRecurrence(Recurrence.RecurrenceType.NONE.name())
            .build();

    public static final Task ALEX_INSULIN = new TaskBuilder().withDesc(VALID_DESC_COVID)
            .withDateTime(VALID_DATE_JAN, VALID_TIME_SEVENPM).withNames(VALID_NAME_ALEX)
            .withRecurrence(Recurrence.RecurrenceType.NONE.name()).build();

    public static final Task DO_PAPERWORK = new TaskBuilder().withDesc(VALID_DESC_PAPERWORK)
            .withDateTime(VALID_DATE_JAN, VALID_TIME_TENAM)
            .withRecurrence(Recurrence.RecurrenceType.MONTH.name()).build();

    public static final Task YASMINE_PHYSIO = new TaskBuilder().withDesc("Physiotherapy with yoga ball")
            .withDateTime("2021-09-13", "15:30").withNames("Yasmine George")
            .withStatus("true", "true").withRecurrence(Recurrence.RecurrenceType.NONE.name()).build();

    public static final Task APPLY_LEAVE = new TaskBuilder().withDesc("Apply leave with HR")
            .withDateTime("2021-10-01", "00:00").withStatus("true", "true")
            .withRecurrence(Recurrence.RecurrenceType.DAY.name()).build();

    public static final Task KG_SC_VACCINE = new TaskBuilder().withDesc(VALID_DESC_VACCINE)
            .withDateTime("2021-10-30", "18:00").withNames("Khong Guan", "Swee Choon")
            .withStatus("false", "true").withRecurrence(Recurrence.RecurrenceType.NONE.name()).build();

    // Extra test cases
    public static final Task APPLY_LEAVE_LATE_TIME = new TaskBuilder().withDesc("Apply leave with HR")
            .withDateTime("2021-10-01", "23:50").withStatus("true", "true")
            .withRecurrence(Recurrence.RecurrenceType.DAY.name()).build();

    public static final Task APPLY_LEAVE_NEXT_DAY = new TaskBuilder().withDesc("Apply leave with HR")
            .withDateTime("2021-10-02", "23:50").withStatus("true", "true")
            .withRecurrence(Recurrence.RecurrenceType.DAY.name()).build();

    public static final Task APPLY_LEAVE_WEEK_RECURRENCE = new TaskBuilder().withDesc("Apply leave with HR")
            .withDateTime("2021-09-30", "23:50").withStatus("true", "true")
            .withRecurrence(Recurrence.RecurrenceType.WEEK.name()).build();

    public static final Task APPLY_LEAVE_MONTH_RECURRENCE = new TaskBuilder().withDesc("Apply leave with HR")
            .withDateTime("2021-07-30", "23:50").withStatus("true", "true")
            .withRecurrence(Recurrence.RecurrenceType.MONTH.name()).build();

    public static final Task APPLY_LEAVE_DAY_NEXT_RECURRENCE_GHOST = new TaskBuilder(false)
            .withDesc("Apply leave with HR Day")
            .withDateTime("2021-10-02", "00:00").withStatus("true", "true")
            .withRecurrence(Recurrence.RecurrenceType.DAY.name()).build();

    public static final Task APPLY_LEAVE_WEEK_NEXT_RECURRENCE_GHOST = new TaskBuilder(false)
            .withDesc("Apply leave with HR Week")
            .withDateTime("2021-10-07", "23:50").withStatus("true", "true")
            .withRecurrence(Recurrence.RecurrenceType.WEEK.name()).build();

    public static final Task APPLY_LEAVE_MONTH_NEXT_RECURRENCE_GHOST = new TaskBuilder(false)
            .withDesc("Apply leave with HR Month")
            .withDateTime("2021-08-27", "23:50").withStatus("true", "true")
            .withRecurrence(Recurrence.RecurrenceType.MONTH.name()).build();

    /**
     * Returns an {@code NurseyBook} with all the typical tasks.
     */
    public static NurseyBook getTypicalNurseyBook() {
        NurseyBook nb = new NurseyBook();
        for (Task t : getTypicalTasks()) {
            nb.addTask(t);
        }
        return nb;
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(Arrays.asList(KEITH_INSULIN, ALEX_INSULIN, DO_PAPERWORK,
                YASMINE_PHYSIO, KG_SC_VACCINE));
    }
}
