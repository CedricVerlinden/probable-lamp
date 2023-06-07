import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Activity[][] activities = {
				{Activity.BUBBLE_SOCCER, Activity.ORIENTATIELOOP, Activity.TOUWENPARCOURS, Activity.KINE_BALL},
				{Activity.TEAM_BUILDING, Activity.BUBBLE_SOCCER, Activity.TOUWENPARCOURS, Activity.ORIENTATIELOOP},
				{Activity.SPIKEBALL, Activity.TEAM_BUILDING, Activity.BUBBLE_SOCCER, Activity.KUBB},
				{Activity.BMX, Activity.SPIKEBALL, Activity.TEAM_BUILDING, Activity.ORIENTATIELOOP},
				{Activity.MEGA_SUP, Activity.BMX, Activity.SPIKEBALL, Activity.TEAM_BUILDING},
				{Activity.TOUWENPARCOURS, Activity.MEGA_SUP, Activity.BMX, Activity.SPIKEBALL},
				{Activity.TOUWENPARCOURS, Activity.ORIENTATIELOOP, Activity.MEGA_SUP, Activity.FRISBEE},
				{Activity.ORIENTATIELOOP, Activity.TOUWENPARCOURS, Activity.FRISBEE, Activity.MEGA_SUP},
				{Activity.KINE_BALL, Activity.TOUWENPARCOURS, Activity.ORIENTATIELOOP, Activity.BEACH_ESCAPE},
				{Activity.KUBB, Activity.KINE_BALL, Activity.ORIENTATIELOOP, Activity.TOUWENPARCOURS},
				{Activity.BEACH_ESCAPE, Activity.KUBB, Activity.KINE_BALL, Activity.TOUWENPARCOURS},
				{Activity.FRISBEE, Activity.BEACH_ESCAPE, Activity.KUBB, Activity.BMX},
				{Activity.ORIENTATIELOOP, Activity.FRISBEE, Activity.BEACH_ESCAPE, Activity.BUBBLE_SOCCER},
		};

		Integer[][] score = {
				{1, 4, 4, 7},
				{8, 10, 5, 2},
				{7, 2, 8, 3},
				{2, 5, 6, 10},
				{9, 2, 9, 7},
				{10, 6, 2, 5},
				{10, 2, 2, 1},
				{1, 3, 3, 7},
				{8, 1, 5, 10},
				{2, 7, 10, 9},
				{3, 2, 9, 3},
				{2, 2, 10, 4},
				{8, 2, 3, 8},
		};

		System.out.println("Highest Scoring Group: " + getGroupWithHighestScoreInActivity(Activity.KINE_BALL, activities, score));

		System.out.println("\n--------------------");
		System.out.println("Lowest Scoring Group: " + getGroupWithLowestScoreInActivity(Activity.SPIKEBALL, activities, score));

		System.out.println("\n--------------------");
		System.out.println("Activies of a group (3) with a min. score: " + getGroupActivitiesWithMinScore(3, 6, activities, score));

		System.out.println("\n--------------------");
		System.out.println("Total score of a certain group (10): " + getTotalScoreOfGroup(10, score));

		System.out.println("\n--------------------");
		System.out.println("Average score of a certain group (4): " + getAverageScoreOfGroup(4, score));

		System.out.println("\n--------------------");
		System.out.println("Winner of the day: " + getWinningGroup(score));
	}

	public static int getGroupWithHighestScoreInActivity(Activity activity, Activity[][] activities, Integer[][] scores) {
		int highestScore = -1;
		int group = -1;
		for (int i = 0; i < activities.length; i++) {
			for (int j = 0; j < activities[i].length; j++) {
				if (activities[i][j] == activity) {
					if (scores[i][j] > highestScore) {
						highestScore = scores[i][j];
						group = i + 1;
					}
				}
			}
		}
		return group;
	}

	public static int getGroupWithLowestScoreInActivity(Activity activity, Activity[][] activities, Integer[][] scores) {
		int lowestScore = -1;
		int group = -1;
		for (int i = 0; i < activities.length; i++) {
			for (int j = 0; j < activities[i].length; j++) {
				if (activities[i][j] == activity) {
					if (lowestScore < scores[i][j]) {
						lowestScore = scores[i][j];
						group = i + 1;
					}
				}
			}
		}
		return group;
	}

	public static ArrayList<Activity> getGroupActivitiesWithMinScore(int group, int minScore, Activity[][] activities, Integer[][] scores) {
		group = group - 1;

		ArrayList<Activity> activitiesResult = new ArrayList<>();
		for (int i = 0; i < scores[group].length; i++) {
			if (scores[group][i] >= minScore) {
				activitiesResult.add(activities[group][i]);
			}
		}

		return activitiesResult;
	}

	public static int getTotalScoreOfGroup(int group, Integer[][] scores) {
		int total = 0;
		for (int i = 0; i < scores[group].length; i++) {
			total += scores[group][i];
		}

		return total;
	}

	public static int getAverageScoreOfGroup(int group, Integer[][] scores) {
		return getTotalScoreOfGroup(group, scores) / scores[group].length;
	}

	public static int getWinningGroup(Integer[][] scores) {
		int highestScore = 0;
		int group = 0;

		for (int i = 0; i < scores.length; i++) {
			int total = 0;
			for (int j = 0; j < scores[i].length; j++) {
				total += scores[i][j];
			}

			if (total > highestScore) {
				highestScore = total;
				group = i + 1;
			}
		}

		return group;
	}

}