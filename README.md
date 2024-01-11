# Writeback Validators

### Basic Setup :

```sh
cd ${projectpath}
npm i
npm i codeceptjs@3.3.6
```

After succesful installation , please navigate to `node_modules\codeceptjs\lib\command\utils.js` and update the method `createOutputDir` with below code

```sh
module.exports.createOutputDir = (config, testRoot) => {
  let outputDir;
  if (path.isAbsolute(config.output)) outputDir = config.output;
  else outputDir = path.join(testRoot, config.output);
  if (!fileExists(outputDir)) {
    output.print(`creating output directory: ${outputDir}`);
    mkdirp.sync(outputDir);
  }
  process.env.RUNID = outputDir.match(/parallel_chunk(\d+)/)[1];
};

```

### Master Database : Supabase

| Column Name         | Data Type                | Default Value                             |
| ------------------- | ------------------------ | ----------------------------------------- |
| id                  | bigint                   |                                           |
| created_at          | timestamp with time zone | (now() at time zone 'Asia/Kolkata'::text) |
| wb_id               | integer                  |                                           |
| type                | text                     |                                           |
| status              | character varying        |                                           |
| env                 | text                     | 'qa'::text                                |
| result              | boolean                  | false                                     |
| scenario_name       | character varying        |                                           |
| destination_details | json[]                   | '{}'::json[]                              |
| ignored_keys        | text                     | 'default'::text                           |
| predefined_col      | text                     | 'default'::text                           |
| seriesforwb         | text[]                   | NULL                                      |

### Database Configurations Supported :

| Database        | Reference      |
| --------------- | -------------- |
| Azure SQL       | AzureSQL       |
| MySQL           | MySQL          |
| PostgreSQL      | PostGreSQL     |
| BigQuery        | BigQuery       |
| Amazon Redshift | AmazonRedShift |
| Snowflake       | SnowFlake      |
| Azure SQL       | AzureManaged   |
| SQL Server      | SQL_Server     |
| ORACLE          | Oracle         |

### Execution Command :

```sh
run.sh
```
